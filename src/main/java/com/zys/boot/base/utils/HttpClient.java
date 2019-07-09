package com.zys.boot.base.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 系统名称: 智慧客服平台
 * 模块名称: 客户关系数据平台
 * 类 名 称: 用于发送HTTP请求的工具
 * 软件版权: 远传股份有限公司
 * 功能说明：为智慧客服平台提供数据支撑
 * 系统版本：v5.0.1.0
 * 开发人员: ZJP
 * 开发时间:
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class HttpClient {

    /**
     * 使用HTTPPOST调用接口的方法
     * @param url
     * @param obj
     * @param sta(DMS 0 , SIEBEL 1 , 4G 2)
     * @return
     */
    public static JSONObject sendHttpByPost(String url, Object obj, Integer sta){
        //创建HttpClient连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //初始化返回数据存放位置
        JSONObject jobOutVo = null;
        //添加post请求的URL地址
        HttpPost httpPost = new HttpPost(url);
        if (sta == 2){
            httpPost.setHeader("appkey","d84ebfa5b5d96df50b8babfae69eb0ca");
        }
        //将JSONObject对象转为String对象
        String json = JSON.toJSONString(obj);
        System.out.println(json);

        //设置编码格式
        StringEntity stringEntity = new StringEntity(json,Consts.UTF_8);
        stringEntity.setContentEncoding("UTF-8");
        //发送json数据需要设置contentType
        if (sta == 2){
            stringEntity.setContentType("application/json");
        } else if (sta == 3){
            stringEntity.setContentType("multipart/from-data;charset=utf-8");
        } else{
            stringEntity.setContentType("text/plain;charset=utf-8");
        }
        httpPost.setEntity(stringEntity);
        //调用接口
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            //判断是否调用成功
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                //获取响应请求中的HttpEntity对象
                HttpEntity httpEntity = httpResponse.getEntity();
                //判断获的的对象是否为空
                if (httpEntity != null) {
                    //初始化字符流
                    BufferedReader reader = null;
                    reader = new BufferedReader(new InputStreamReader(httpEntity.getContent(), "UTF-8"), 10 *1024);
                    //初始化属性
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    //读取字符流
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    //将字符串转为JSON对象
                    jobOutVo = JSON.parseObject(stringBuilder.toString());
                    if (reader != null) {
                        //关闭流
                        reader.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobOutVo;
    }

    /**
     * 使用HTTPPOST调用接口的方法
     * @param url
     * @param json
     * @param sta(DMS 0 , SIEBEL 1 , 4G 2)
     * @return
     */
    public static JSONObject sendHttpByPost(String url, String json, Integer sta){
        System.out.println("2");
        //创建HttpClient连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //初始化返回数据存放位置
        JSONObject jobOutVo = null;
        //添加post请求的URL地址
        HttpPost httpPost = new HttpPost(url);
        if (sta == 2){
            httpPost.setHeader("appkey","d84ebfa5b5d96df50b8babfae69eb0ca");
        }
        //设置编码格式
        StringEntity stringEntity = new StringEntity(json, Consts.UTF_8);
        stringEntity.setContentEncoding("UTF-8");
        //发送json数据需要设置contentType
        if (sta == 2){
            stringEntity.setContentType("application/json");
        } else if (sta == 3){
            stringEntity.setContentType("multipart/from-data;charset=utf-8");
        } else{
            stringEntity.setContentType("text/plain;charset=utf-8");
        }
        httpPost.setEntity(stringEntity);
        //调用接口
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            //判断是否调用成功
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                //获取响应请求中的HttpEntity对象
                HttpEntity httpEntity = httpResponse.getEntity();
                //判断获的的对象是否为空
                if (httpEntity != null) {
                    //初始化字符流
                    BufferedReader reader = null;
                    reader = new BufferedReader(new InputStreamReader(httpEntity.getContent(), "UTF-8"), 10 *1024);
                    //初始化属性
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    //读取字符流
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    //将字符串转为JSON对象
                    jobOutVo = JSON.parseObject(stringBuilder.toString());
                    if (reader != null) {
                        //关闭流
                        reader.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobOutVo;
    }
}
