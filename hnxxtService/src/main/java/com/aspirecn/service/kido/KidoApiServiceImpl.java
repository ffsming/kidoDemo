package com.aspirecn.service.kido;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aspirecn.controller.InterfaceCode;
import com.aspirecn.util.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class KidoApiServiceImpl implements KidoApiService {

    @Value("${kido.url}")
    private String kidoUrl;

    /**
     * 注册登录
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> login(String param) {
        Map<String, Object> resultMap = toKido("Login", param);
        return resultMap;
    }
    /**
     * 获取孩子列表接口
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> getChildList(String param) {
        Map<String, Object> resultMap = toKido("GetChildList", param);
        return resultMap;
    }
    /**
     * 添加小孩接口
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> addChild(String param) {
        Map<String, Object> resultMap = toKido("AddChild", param);
        return resultMap;
    }
    /**
     * 解除绑定手表接口
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> unbindWatch(String param) {
        Map<String, Object> resultMap = toKido("UnbindWatch", param);
        return resultMap;
    }
    /**
     * 绑定手表接口
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> bindingWatch(String param) {
        Map<String, Object> resultMap = toKido("BindingWatch", param);
        return resultMap;
    }
    /**
     * 删除小孩接口（只有在解绑后才能删除小孩）
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> updateFamilyNumFollow(String param) {
        Map<String, Object> resultMap = toKido("UpdateFamilyNumFollow", param);
        return resultMap;
    }
    /**
     * 获取主界面接口
     * @param param
     * @return
     */
    @Override
    public Map<String, Object> getMainInterface(String param) {
        Map<String, Object> resultMap = toKido("GetMainInterface", param);
        return resultMap;
    }

    private Map<String, Object> toKido(String key, String param) {
        Map<String, Object> resultMap = new HashMap<>();
        String result = HttpClientUtil.doPostJSON(kidoUrl + key, param, "utf-8");
        Map<String, Object> map = JSON.parseObject(result, Map.class);
        log.info("返回map = {}", map);
        if (map.containsKey("d")) {
            JSONObject jsonObject = (JSONObject) map.get("d");
            map = JSON.parseObject(JSON.toJSONString(jsonObject), Map.class);
            log.info("返回map处理之后的 = {}", map);
        }
        if (map.containsKey("Code") && "0".equalsIgnoreCase((String) map.get("Code"))) {
            resultMap.put(InterfaceCode.STATUS, InterfaceCode.SUCCESS);
            resultMap.put(InterfaceCode.ERRMSG, "处理成功");
            resultMap.put(InterfaceCode.DATA, map.get("Data"));
            return resultMap;
        }
        resultMap.put(InterfaceCode.STATUS, InterfaceCode.ERROR);
        resultMap.put(InterfaceCode.ERRMSG, map.get("Message"));
        return resultMap;
    }


}
