package com.aspirecn.pojo.watch;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * smartwatch_kid_info
 *
 * @author
 */
@Data
public class RequireSmartwatchKidInfo implements Serializable {
    /**
     * 家长的KIDO userId
     */
    private Integer userId;
    /**
     * 孩子id
     */
    private Integer childId;

    @JSONField(name = "SessionKey")
    private String sessionKey;


}