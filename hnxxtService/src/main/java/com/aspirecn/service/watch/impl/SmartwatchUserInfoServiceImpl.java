package com.aspirecn.service.watch.impl;

import com.alibaba.fastjson.JSON;
import com.aspirecn.controller.InterfaceCode;
import com.aspirecn.dao.watch.SmartwatchUserInfoMapper;
import com.aspirecn.pojo.watch.SmartwatchUserInfo;
import com.aspirecn.service.kido.KidoApiService;
import com.aspirecn.service.watch.SmartwatchUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class SmartwatchUserInfoServiceImpl implements SmartwatchUserInfoService {

    @Resource
    private SmartwatchUserInfoMapper userInfoMapper;

    @Resource
    private KidoApiService kidoApiService;

    @Override
    public int insert(SmartwatchUserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public SmartwatchUserInfo selectByPrimaryKey(SmartwatchUserInfo record) {
        return userInfoMapper.selectByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SmartwatchUserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmartwatchUserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public Map<String, Object> login(String mobile) {
        Map<String, Object> resultMap = new HashMap<>();

        SmartwatchUserInfo userInfo = new SmartwatchUserInfo();
        userInfo.setPhoneNum(mobile);
        userInfo = this.selectByPrimaryKey(userInfo);
        if (userInfo == null || userInfo.getUserId() == null) {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("phoneNum", mobile);
            Map<String, Object> rMap = kidoApiService.login(JSON.toJSONString(paramMap));
            if (rMap.containsKey(InterfaceCode.DATA)) {
                Map<String, Object> mMap = (Map<String, Object>) rMap.get(InterfaceCode.DATA);
                userInfo = new SmartwatchUserInfo();
                userInfo.setPhoneNum(mobile);
                userInfo.setUserId((Integer) mMap.get("UserId"));
                userInfo.setSessionKey((String) mMap.get("SessionKey"));
                userInfoMapper.insert(userInfo);

                resultMap.put(InterfaceCode.STATUS, InterfaceCode.SUCCESS);
                resultMap.put(InterfaceCode.ERRMSG, "");
                resultMap.put(InterfaceCode.DATA, userInfo);
                return resultMap;
            }
        }
        resultMap.put(InterfaceCode.STATUS, InterfaceCode.SUCCESS);
        resultMap.put(InterfaceCode.ERRMSG, "");
        resultMap.put(InterfaceCode.DATA, userInfo);
        return resultMap;
    }
}
