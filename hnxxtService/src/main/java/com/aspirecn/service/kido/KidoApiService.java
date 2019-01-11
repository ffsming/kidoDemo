package com.aspirecn.service.kido;

import java.util.Map;

public interface KidoApiService {
    Map<String, Object> login(String param);

    Map<String, Object> getChildList(String param);

    Map<String, Object> addChild(String param);

    Map<String, Object> bindingWatch(String param);

    Map<String, Object> unbindWatch(String param);

    Map<String, Object> updateFamilyNumFollow(String param);

    Map<String, Object> getMainInterface(String param);
}
