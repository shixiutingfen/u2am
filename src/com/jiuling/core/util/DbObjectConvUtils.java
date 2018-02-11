package com.jiuling.core.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DbObjectConvUtils {
    // private static Map<String,String> tableClassMappingCache = new ConcurrentHashMap<String,String>(50);
    private static Map<String, String> classTableMappingCache = new ConcurrentHashMap<String, String>(50);
    private static Map<String, String> propertyFieldMappingCache = new ConcurrentHashMap<String, String>(50);
    private static Map<String, String> fieldPropertyMappingCache = new ConcurrentHashMap<String, String>(50);

    /**
     * 将库表字段名转换为属性名（USER_ID -->userId）
     * 
     * @param fieldName
     * @return
     */
    public static String getPropertyNameFromFieldName(String fieldName) {
        if (StringUtils.isEmptyString(fieldName))
            return null;
        if (fieldPropertyMappingCache.containsKey(fieldName)) {
            return fieldPropertyMappingCache.get(fieldName);
        }
        StringBuilder build = new StringBuilder();
        char[] chars = fieldName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (build.length() == 0) {
                build.append(StringUtils.toLowerCase(c));
            } else {
                if (c == '_') {
                    i++;
                    build.append(StringUtils.toUpperCase(chars[i]));
                } else {
                    build.append(StringUtils.toLowerCase(c));
                }
            }
        }

        String propertyName = build.toString();
        fieldPropertyMappingCache.put(fieldName, propertyName);
        return propertyName;
    }

    /**
     * 将属性名转换为库表字段名（userId -->USER_ID）
     * 
     * @param fieldName
     * @return
     */
    @SuppressWarnings("unused")
    public static String getmFieldNameFromPropertyName(String propertyName) {
        if (StringUtils.isEmptyString(propertyName))
            return null;
        if (propertyFieldMappingCache.containsKey(propertyName)) {
            return propertyFieldMappingCache.get(propertyName);
        }
        StringBuilder build = new StringBuilder();
        char[] chars = propertyName.toCharArray();
        for (char c : propertyName.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                if (build.length() > 0) {
                    build.append("_");
                }
            }
            build.append(c);
        }

        String fieldName = new String(build.toString().toUpperCase());
        propertyFieldMappingCache.put(propertyName, fieldName);
        return fieldName;
    }

    /**
     * 将类名转为表名
     * 
     * @param className
     * @return
     */
    public static String getTableNameFromClassName(String className) {
        if (StringUtils.isEmptyString(className))
            return null;
        if (classTableMappingCache.containsKey(className)) {
            return classTableMappingCache.get(className);
        }
        StringBuilder builder = new StringBuilder();
        for (char c : className.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                if (builder.length() > 0) {
                    builder.append("_");
                }
            }
            builder.append(c);
        }
        String tableName = new String(builder.toString().toUpperCase());
        return tableName;
    }

    /**
     * 将pojo对象转换为map输出，并且将pojo的属性名转换为数据库字段名做完map 的key
     * 
     * @param object
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getMapFromBean(Object object) throws Exception {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            String propertyName = field.getName();
            String columnName = getmFieldNameFromPropertyName(propertyName);
            field.setAccessible(true);
            Object value = field.get(object);
            field.setAccessible(false);
            paramMap.put(columnName, value);
        }
        return paramMap;
    }

    /**
     * 将map里面key值由属性转换为字段名
     * 
     * @param map
     * @return
     */
    public static Map<String, Object> getMapFromPropertyFieldName(Map<String, Object> map) {
        Map<String, Object> result = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String fieldName = getmFieldNameFromPropertyName(entry.getKey());
            Object object = entry.getValue();
            result.put(fieldName, object);
        }
        return result;
    }

    /**
	 * 
	 */
    public static List<Map<String, Object>> convertList(List<Map<String, Object>> list) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        if (list != null && list.size() > 0) {
            for (Map<String, Object> item : list) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (Map.Entry<String, Object> entry : item.entrySet()) {
                    String propertyName = getPropertyNameFromFieldName(entry.getKey());
                    Object object = entry.getValue();
                    map.put(propertyName, object);
                }
                result.add(map);
            }
        }
        return result;
    }
}
