package com.aspirecn.pojo.watch;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * smartwatch_user_info
 * @author 
 */
@Data
public class SmartwatchUserInfo implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 家长手机号
     */
    private String phoneNum;

    /**
     * 平台校讯通id（家长）
     */
    private Integer xxtId;

    /**
     * 对应的智能手表的id
     */
    private Integer userId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 注册状态：0未注册 1已注册 2已注销
     */
    private Byte userStatus;

    private Date addTime;

    private Date modifyTime;

    /**
     * 备注字段1
     */
    private String prop1;

    private String sessionKey;

    private static final long serialVersionUID = 1L;

}