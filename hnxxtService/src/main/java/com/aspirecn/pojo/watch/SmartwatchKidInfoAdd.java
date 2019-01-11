package com.aspirecn.pojo.watch;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * smartwatch_kid_info
 *
 * @author
 */
@Data
public class SmartwatchKidInfoAdd implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 家长的KIDO userId
     */
    private Integer userId;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phoneNum;
    @JSONField(name = "IMEI")
    private String imei;

    private String callName;

    /**
     * 头像url
     */
    private Integer imageIndex;
    @JSONField(name = "SessionKey")
    private String sessionKey;


}