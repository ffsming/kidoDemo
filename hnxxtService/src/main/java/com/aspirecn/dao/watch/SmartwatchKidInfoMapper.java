package com.aspirecn.dao.watch;

import com.aspirecn.pojo.watch.SmartwatchKidInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartwatchKidInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartwatchKidInfo record);

    int insertSelective(SmartwatchKidInfo record);

    SmartwatchKidInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartwatchKidInfo record);

    int updateByPrimaryKey(SmartwatchKidInfo record);
}