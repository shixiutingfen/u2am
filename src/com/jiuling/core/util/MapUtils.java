package com.jiuling.core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * 通过key获取指定的值转换为指定类型返回
 * 
 * @author qing
 *
 */
public class MapUtils {

    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    @SuppressWarnings("rawtypes")
    public static boolean isNotEmpty(Map map) {
        return map != null && !map.isEmpty();
    }

    @SuppressWarnings("rawtypes")
    public static String getString(Map map, String key) {
        Object value = map.get(key);
        return value == null ? "" : String.valueOf(value);
    }

    @SuppressWarnings("rawtypes")
    public static Long getLong(Map map, String key) {
        Object value = map.get(key);
        return value == null ? null : Long.parseLong(String.valueOf(value));
    }

    @SuppressWarnings("rawtypes")
    public static Integer getIntegr(Map map, String key) {
        Object value = map.get(key);
        return value == null ? null : Integer.parseInt(String.valueOf(value));
    }

    // po或者dto转换为map，key为字段名
    @SuppressWarnings("rawtypes")
    public static Map<String, Object> getMapFromObject(Object object) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (object != null) {
                Set propertys = BeanUtils.describe(object).keySet();
                for (Object opropertyName : propertys) {
                    String propertyName = opropertyName.toString();
                    if (!propertyName.equals("class")) {
                        Object propertyValue = PropertyUtils.getNestedProperty(object, propertyName);
                        map.put(propertyName, propertyValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
