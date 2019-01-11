package com.aspirecn.dao.watch;

import com.aspirecn.pojo.watch.SmartwatchUserInfo;
import org.springframework.stereotype.Repository;

public interface SmartwatchUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartwatchUserInfo record);

    SmartwatchUserInfo selectByPrimaryKey(SmartwatchUserInfo record);

    int updateByPrimaryKeySelective(SmartwatchUserInfo record);

    int updateByPrimaryKey(SmartwatchUserInfo record);
}