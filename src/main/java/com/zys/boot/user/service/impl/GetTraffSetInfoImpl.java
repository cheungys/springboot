package com.zys.boot.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zys.boot.base.dao.*;
import com.zys.boot.base.entity.Dict;
import com.zys.boot.base.entity.InterfaceEntity;
import com.zys.boot.base.entity.SysCallLogEntity;
import com.zys.boot.base.entity.SysParamEntity;
import com.zys.boot.base.exception.CommonException;
import com.zys.boot.base.utils.HttpClient;
import com.zys.boot.base.utils.InterfaceUtil;
import com.zys.boot.base.utils.SaveIfacLogUtil;
import com.zys.boot.user.dao.CardInfoMapper;
import com.zys.boot.user.dao.OrderPKGMapper;
import com.zys.boot.user.dao.PurchRecordMapper;
import com.zys.boot.user.entity.CardInfo;
import com.zys.boot.user.entity.OrderPKG;
import com.zys.boot.user.entity.PurchRecord;
import com.zys.boot.user.model.TraffInVo;
import com.zys.boot.user.model.VoiceTraffDTO;
import com.zys.boot.user.service.GetTraffSetInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class GetTraffSetInfoImpl implements GetTraffSetInfo {

    @Resource
    private SysParamEntityMapper sysParamEntityMapper;
    @Resource
    private InterfaceEntityMapper interfaceEntityMapper;
    @Resource
    private CardInfoMapper cardInfoMapper;
    @Resource
    private PurchRecordMapper purchRecordMapper;
    @Resource
    private OrderPKGMapper orderPKGMapper;
    @Resource
    private DictMapper dictMapper;
    @Resource
    private SysCallLogEntityMapper sysCallLogEntityMapper;

    @Override
    public List<VoiceTraffDTO> getTarffInfo(TraffInVo traffInVo) throws Exception {
        Dict dict;
        List<VoiceTraffDTO> voiceTraffDTOList = new ArrayList<>();
        //获取接口地址
        SysParamEntity sysParamEntity = sysParamEntityMapper.selectByParamKey("RUN_ENVIRONMENT");
        InterfaceEntity record = new InterfaceEntity();
        record.setEnvirenment(Byte.valueOf(sysParamEntity.getParamValue()));
        record.setName(InterfaceUtil.SRV_VIV_ICCID_PLG_USED_INFO);
        InterfaceEntity interfaceEntity = interfaceEntityMapper.selectByNameAndEnv(record);
        String url = interfaceEntity.getUrl();
        //记录接口开始日志
        SysCallLogEntity sysCallLogEntity;
        Date beginTime = new Date();
        Integer id = interfaceEntity.getId();
        System.out.println("我的请求参数" + traffInVo.toString());

        //调用接口
        JSONObject jsonObject = HttpClient.sendHttpByPost(url, traffInVo, 2);

        System.out.println("结果返回数据" + jsonObject.toJSONString());

        if (jsonObject == null) throw new CommonException("调用服务失败");
        if (jsonObject.getString("result").equals("000000")) {
            VoiceTraffDTO voiceTraffDTO = JSON.parseObject(jsonObject.getJSONObject("VoiceTraffInfo").getString("VoiceTraffDTO"), VoiceTraffDTO.class);
            voiceTraffDTO.setVin(traffInVo.getVin());

            List<OrderPKG> orderPKGList = voiceTraffDTO.getOrderPKGList();
            List<PurchRecord> purchRecordList = voiceTraffDTO.getPurchRecordList();

            if (voiceTraffDTO == null) {
                return null;
            } else {

                String vehiclePhone = voiceTraffDTO.getVehiclePhone();
                CardInfo cardInfo = new CardInfo();
                cardInfo.setVehiclePhone(vehiclePhone);
                cardInfo.setIccid(voiceTraffDTO.getIccid());
                cardInfo.setCarrOperator(Integer.parseInt(voiceTraffDTO.getCarrOperator()));
                cardInfo.setSerStatus(Integer.parseInt(voiceTraffDTO.getSerStatus()));
                cardInfo.setApn1Status(Integer.parseInt(voiceTraffDTO.getApn1Status()));
                cardInfo.setApn2Status(Integer.parseInt(voiceTraffDTO.getApn2Status()));
                cardInfo.setMonthTotalTraff(voiceTraffDTO.getMonthTotalTraff());
                cardInfo.setBcallSetSize(voiceTraffDTO.getBcallSetSize());
                cardInfo.setCarModelSn(voiceTraffDTO.getCarModelSN());
                cardInfo.setCarModelName(voiceTraffDTO.getCarModelName());
                cardInfo.setCellphone(voiceTraffDTO.getCellPhone());
                cardInfo.setCity(voiceTraffDTO.getCity());
                cardInfo.setCustPhone(voiceTraffDTO.getCellPhone());
                cardInfo.setCustName(voiceTraffDTO.getCustName());
                cardInfo.setMegTotal(voiceTraffDTO.getMegTotal());
                cardInfo.setMonthTotalTraff(voiceTraffDTO.getMonthTotalTraff());
                cardInfo.setPlateNumber(voiceTraffDTO.getPlateNum());
                cardInfo.setResidualTraff(voiceTraffDTO.getResidueTraff());
                cardInfo.setUsedTraff(voiceTraffDTO.getUsedTraff());
                cardInfo.setVoiUsedAmount(voiceTraffDTO.getVoiUseAmount());
                //查看库里是否存在数据
                CardInfo cards = cardInfoMapper.selectByVehiclePhone(vehiclePhone);

                if (null != cards) {
                    //修改数据库里的数据
                    cardInfoMapper.updateByPrimaryKeySelective(cardInfo);
                    if (orderPKGList.size() != 0 || null != orderPKGList) {
                        for (OrderPKG orderPKG : orderPKGList) {
                            if (null != vehiclePhone) {
                                List<OrderPKG> orderPKGs = orderPKGMapper.selectByVehiclePhone(vehiclePhone);
                                if (orderPKGs.size() != 0) {
                                    orderPKGMapper.updateByPrimaryKeySelective(orderPKG);
                                } else {
                                    orderPKGMapper.insertSelective(orderPKG);
                                }
                            }
                        }
                    }
                    if (purchRecordList.size() != 0 || null != purchRecordList) {
                        for (PurchRecord purchRecord : purchRecordList) {
                            List<PurchRecord> purchRecordLists = purchRecordMapper.selectByOrderNumTraff(purchRecord.getOrderNumTraff());
                            if (null == purchRecordLists || purchRecordLists.size() == 0) {
                                purchRecordMapper.insertSelective(purchRecord);
                            }
                        }
                    }
                } else {
                    //修改数据库里的数据
                    cardInfoMapper.insertSelective(cardInfo);
                    if (orderPKGList.size() != 0 || null != orderPKGList) {
                        for (OrderPKG orderPKG : orderPKGList) {
                            if (null != vehiclePhone) {
                                List<OrderPKG> orderPKGs = orderPKGMapper.selectByVehiclePhone(vehiclePhone);
                                if (orderPKGs.size() != 0) {
                                    orderPKGMapper.updateByPrimaryKeySelective(orderPKG);
                                } else {
                                    orderPKGMapper.insertSelective(orderPKG);
                                }
                            }
                        }
                    }
                    if (purchRecordList.size() != 0 || null != purchRecordList) {
                        for (PurchRecord purchRecord : purchRecordList) {
                            List<PurchRecord> purchRecordLists = purchRecordMapper.selectByOrderNumTraff(purchRecord.getOrderNumTraff());
                            if (null == purchRecordLists || purchRecordLists.size() == 0) {
                                purchRecordMapper.insertSelective(purchRecord);
                            }
                        }
                    }
                }

                //处理套餐列表数据字典
                for (OrderPKG orderPKG : orderPKGList) {
                    if (!"".equals(orderPKG.getPkgType())) {
                        dict = dictMapper.selectByKeyAndBelid(orderPKG.getPkgType(), 3);
                        orderPKG.setPkgType(dict.getDictValue());
                    }
                }
                //处理购买记录数据字典
                for (PurchRecord purchRecord : purchRecordList) {
                    String voiceSetType = purchRecord.getVoiceSet();
                    String traffSetType = purchRecord.getTraffSet();
                    if (!"".equals(voiceSetType)) {
                        dict = dictMapper.selectByKeyAndBelid(voiceSetType, 3);
                        purchRecord.setVoiceSet(dict.getDictValue());
                    }
                    if (!"".equals(traffSetType)) {
                        dict = dictMapper.selectByKeyAndBelid(traffSetType, 3);
                        purchRecord.setTraffSet(dict.getDictValue());
                    }
                }

                String apn1 = voiceTraffDTO.getApn1Status();//APN1状态
                String apn2 = voiceTraffDTO.getApn2Status();//APN2状态
                String carrOperator = voiceTraffDTO.getCarrOperator(); //运营商
                String serStatus = voiceTraffDTO.getSerStatus();//服务状态
                String voiStatus = voiceTraffDTO.getVoiceStatus();//语音状态

                //以下为处理套餐详细信息 处理APN1状态
                if (!"".equals(apn1)) {
                    dict = dictMapper.selectByKeyAndBelid(apn1, 2);
                    voiceTraffDTO.setApn1Status(dict.getDictValue());
                }

                //处理APN2状态
                if (!"".equals(apn2)) {
                    dict = dictMapper.selectByKeyAndBelid(apn2, 2);
                    voiceTraffDTO.setApn2Status(dict.getDictValue());
                }

                //处理运营商
                if (!"".equals(carrOperator)) {
                    dict = dictMapper.selectByKeyAndBelid(carrOperator, 0);
                    voiceTraffDTO.setCarrOperator(dict.getDictValue());
                }

                //处理服务状态
                if (!"".equals(serStatus)) {
                    dict = dictMapper.selectByKeyAndBelid(serStatus, 1);
                    voiceTraffDTO.setSerStatus(dict.getDictValue());
                }

                //处理语音状态
                if (!"".equals(voiStatus)) {
                    dict = dictMapper.selectByKeyAndBelid(voiStatus, 2);
                    voiceTraffDTO.setVoiceStatus(dict.getDictValue());
                }
                //接口调用成功记录日志
                Date endTIme = new Date();
                sysCallLogEntity = SaveIfacLogUtil.saveIfacLog(JSON.toJSONString(traffInVo), jsonObject.toString(), null, beginTime, endTIme, id, null);
                sysCallLogEntityMapper.insertSelective(sysCallLogEntity);
                System.out.println("*****************" + voiceTraffDTO.toString());
                voiceTraffDTOList.add(voiceTraffDTO);
                return voiceTraffDTOList;

            }

        } else {
            //接口调用失败记录日志
            Date endTme = new Date();
            sysCallLogEntity = SaveIfacLogUtil.saveIfacLog(JSON.toJSONString(traffInVo), jsonObject.toString(), null, beginTime, endTme, id, null);
            sysCallLogEntityMapper.insertSelective(sysCallLogEntity);

            //服务正常，返回数据失败（该参数未找到任何数据）
            if (jsonObject.getString("result").equals("000001")) {
                throw new CommonException(jsonObject.getString("failReason"));
            }

            //接口返回报错信息
            if (jsonObject.getJSONObject("result").containsKey("999999"))
                throw new CommonException(jsonObject.getString("failReason"));
            System.out.println("failReason为" + jsonObject.getString("failReason"));
            throw new CommonException("调用接口失败！请检查失败原因" + jsonObject.getJSONObject("failReason").toString());
        }
    }
}
