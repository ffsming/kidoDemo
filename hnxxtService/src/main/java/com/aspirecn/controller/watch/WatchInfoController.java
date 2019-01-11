package com.aspirecn.controller.watch;

import com.alibaba.fastjson.JSON;
import com.aspirecn.controller.InterfaceCode;
import com.aspirecn.pojo.watch.*;
import com.aspirecn.service.kido.KidoApiService;
import com.aspirecn.service.watch.SmartwatchUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/watch")
@Slf4j
public class WatchInfoController {

    @Autowired
    private SmartwatchUserInfoService userInfoService;

    @Autowired
    private KidoApiService kidoApiService;

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestParam(value = "mobile") String mobile) {
        log.info("登录接口，mobile={}", mobile);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap = userInfoService.login(mobile);
        return resultMap;
    }

    /**
     * 获取孩子列表接口
     *
     * @return
     */
    @RequestMapping("/getChildList")
    public Map<String, Object> getChildList(@RequestBody SmartwatchUserInfo record) {
        log.info("获取孩子列表接口，record={}", record);
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", record.getUserId());
        paramMap.put("SessionKey", record.getSessionKey());
        resultMap = kidoApiService.getChildList(JSON.toJSONString(paramMap));
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("ChildId", 2041);
        paramMap1.put("NickName", "高蔓怡");
        paramMap1.put("Sex", 0);
        paramMap1.put("PhoneNum", "156798213");
        paramMap1.put("WatchId", "557143048801877");
        paramMap1.put("ImageUrl", "");
        List<Map<String, Object>> arrList = (List<Map<String, Object>>) resultMap.get(InterfaceCode.DATA);
//        resultMap.put(InterfaceCode.DATA, arrList);
        if (arrList != null && arrList.size() > 0) {
            for (int i = 0; i < arrList.size(); i++) {
                Map<String ,Object> map = arrList.get(i);
                RequireSmartwatchKidInfo requireSmartwatchKidInfo = new RequireSmartwatchKidInfo();
                requireSmartwatchKidInfo.setChildId((Integer) map.get("ChildId"));
                requireSmartwatchKidInfo.setSessionKey(record.getSessionKey());
                requireSmartwatchKidInfo.setUserId(record.getUserId());
                Map<String, Object> reMap = kidoApiService.getMainInterface(JSON.toJSONString(requireSmartwatchKidInfo));
                if(reMap.containsKey(InterfaceCode.DATA)){
                    map.put("index",reMap.get(InterfaceCode.DATA));
                }
            }
        }
        log.info("获取宝贝列表返回={}",resultMap);
        return resultMap;
    }

    /**
     * 添加小孩接口
     *
     * @return
     */
    @RequestMapping("/addChild")
    public Map<String, Object> addChild(@RequestBody SmartwatchKidInfoAdd record) {
        log.info("添加小孩接口，record={}", record);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap = kidoApiService.addChild(JSON.toJSONString(record));
        return resultMap;
    }

    /**
     * 解除绑定手表接口
     *
     * @return
     */
    @RequestMapping("/unbindWatch")
    public Map<String, Object> unbindWatch(@RequestBody RequireSmartwatchKidInfo record) {
        log.info("解除绑定手表接口，unbindWatch={}", record);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap = kidoApiService.unbindWatch(JSON.toJSONString(record));
        return resultMap;
    }

    /**
     * 绑定手表接口
     *
     * @return
     */
    @RequestMapping("/bindingWatch")
    public Map<String, Object> bindingWatch(@RequestBody RequireSmartwatchKidBind record) {
        log.info("绑定手表接口，record={}", record);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap = kidoApiService.bindingWatch(JSON.toJSONString(record));
        return resultMap;
    }

    /**
     * 删除小孩接口（只有在解绑后才能删除小孩）
     *
     * @return
     */
    @RequestMapping("/updateFamilyNumFollow")
    public Map<String, Object> updateFamilyNumFollow(@RequestBody RequireSmartwatchKidUpdate record) {
        log.info("删除小孩接口，record={}", record);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap = kidoApiService.updateFamilyNumFollow(JSON.toJSONString(record));
        return resultMap;
    }

    /**
     * 获取主界面接口
     *
     * @return
     */
    @RequestMapping("/getMainInterface")
    public Map<String, Object> getMainInterface(@RequestBody RequireSmartwatchKidInfo record) {
        log.info("获取主界面接口，record={}", record);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap = kidoApiService.getMainInterface(JSON.toJSONString(record));
        return resultMap;
    }
}
