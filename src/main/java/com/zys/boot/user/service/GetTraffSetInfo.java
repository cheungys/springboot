package com.zys.boot.user.service;

import com.zys.boot.user.model.TraffInVo;
import com.zys.boot.user.model.VoiceTraffDTO;

import java.util.List;

public interface GetTraffSetInfo {
    List<VoiceTraffDTO> getTarffInfo(TraffInVo traffInVo) throws Exception;
}
