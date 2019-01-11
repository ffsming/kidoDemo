package com.aspirecn.pojo.watch;

import lombok.Data;

import java.io.Serializable;

/**
 * smartwatch_kid_info
 *
 * @author
 */
@Data
public class SmartwatchKidInfo implements Serializable {
    private Integer id;
    /**
     * 家长的KIDO userId
     */
    private Integer userId;
    /**
     * 孩子id
     */
    private Integer childId;


    /**
     * 家长的xxtId
     */
    private Integer parentXxtId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别：0未知 1男 2女
     */
    private Byte sex;

    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 绑定手表的id
     */
    private String watchId;

    /**
     * 头像url
     */
    private String imageUrl;

    private static final long serialVersionUID = 1L;

}