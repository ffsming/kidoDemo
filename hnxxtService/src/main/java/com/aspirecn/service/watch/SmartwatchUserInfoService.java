package com.aspirecn.service.watch;

import com.aspirecn.pojo.watch.SmartwatchUserInfo;

import java.util.Map;

public interface SmartwatchUserInfoService {
    int insert(SmartwatchUserInfo record);

    SmartwatchUserInfo selectByPrimaryKey(SmartwatchUserInfo record);

    int updateByPrimaryKeySelective(SmartwatchUserInfo record);

    int updateByPrimaryKey(SmartwatchUserInfo record);

    public Map<String,Object> login(String mobile);
}
