package com.springboot.admin.common.util;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Json 工具类
 *
 * @author ZhangJun
 * @date 2020/9/18 16:13
 **/
public class JsonUtil {
    /**
     * Gson 主类
     */
    public static final Gson GSON = new GsonBuilder()
            // 字段保留原始
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            // 支持复杂键值映射(值不调用默认toString, 而是序列化为JsonObject)
            .enableComplexMapKeySerialization()
            // 保留空字段
            .serializeNulls()
            .create();
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * 将Json 字符串解析为JsonArray 数组
     *
     * @param jsonStr Json 字符串
     * @return JsonArray 数组
     */
    public static JsonArray parseJsonArray(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            JsonElement jsonElement = JsonParser.parseString(jsonStr);
            if (jsonElement != null && jsonElement.isJsonArray()) {
                return jsonElement.getAsJsonArray();
            } else {
                return null;
            }
        } catch (JsonParseException e) {
            LOGGER.error("parseJsonArray: " + e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * 将Json 字符串解析为JsonObject
     *
     * @param jsonStr Json 字符串
     * @return JsonObject
     */
    public static JsonObject parseJsonObject(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            JsonElement jsonElement = JsonParser.parseString(jsonStr);
            if (jsonElement != null && jsonElement.isJsonObject()) {
                return jsonElement.getAsJsonObject();
            } else {
                return null;
            }
        } catch (JsonParseException e) {
            LOGGER.error("parseJsonObject: " + e.getLocalizedMessage());
            return null;
        }
    }

    /**
     * 将Json 字符串解析为JsonPrimitive 原始类型
     *
     * @param jsonStr Json 字符串
     * @return JsonPrimitive 原始类型 e.g. String, int, ...
     */
    public static JsonPrimitive parseJsonPrimitive(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            JsonElement jsonElement = JsonParser.parseString(jsonStr);
            if (jsonElement != null && jsonElement.isJsonPrimitive()) {
                return jsonElement.getAsJsonPrimitive();
            } else {
                return null;
            }
        } catch (JsonParseException e) {
            LOGGER.error("parseJsonPrimitive: " + e.getLocalizedMessage());
            return null;
        }
    }


    /**
     * 从JsonObject 中获得指定参数
     *
     * @param paramName 参数名称，
     * @return String 类型参数
     */
    public static String getParamAsString(JsonObject jsonObject, String paramName) throws IllegalStateException, ClassCastException {
        // jsonObject 为空或参数不存在
        if (jsonObject == null || !jsonObject.has(paramName)) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(paramName);

        // 参数值并非原始类型
        if (!jsonElement.isJsonPrimitive()) {
            LOGGER.warn("getParamAsString: 参数[" + paramName + "] 的值并非原始类型");
            return null;
        }
        JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();

        // 参数值并非String
        if (!jsonPrimitive.isString()) {
            LOGGER.warn("getParamAsString: 参数[" + paramName + "] 的值并非String");
            return null;
        }

        return jsonPrimitive.getAsString();
    }

    /**
     * 从JsonObject 中获得指定参数
     *
     * @param paramName 参数名称，
     * @return Boolean 类型参数
     */
    public static Boolean getParamAsBoolean(JsonObject jsonObject, String paramName) {
        // jsonObject 为空或参数不存在
        if (jsonObject == null || !jsonObject.has(paramName)) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(paramName);

        // 参数值并非原始类型
        if (!jsonElement.isJsonPrimitive()) {
            LOGGER.warn("getParamAsBoolean: 参数[" + paramName + "] 的值并非原始类型");
            return null;
        }
        JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();

        // 参数值并非String
        if (!jsonPrimitive.isBoolean()) {
            LOGGER.warn("getParamAsBoolean: 参数[" + paramName + "] 的值并非Boolean");
            return null;
        }

        return jsonPrimitive.getAsBoolean();
    }

    /**
     * 从JsonObject 中获得指定参数
     *
     * @param paramName 参数名称，
     * @return Integer 类型参数
     */
    public static Integer getParamAsInteger(JsonObject jsonObject, String paramName) {
        // jsonObject 为空或参数不存在
        if (jsonObject == null || !jsonObject.has(paramName)) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(paramName);

        // 参数值并非原始类型
        if (!jsonElement.isJsonPrimitive()) {
            LOGGER.warn("getParamAsInteger: 参数[" + paramName + "] 的值并非原始类型");
            return null;
        }
        JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();

        // 参数值并非String
        if (!jsonPrimitive.isNumber()) {
            LOGGER.warn("getParamAsInteger: 参数[" + paramName + "] 的值并非数字");
            return null;
        }

        return jsonPrimitive.getAsInt();
    }

    /**
     * 从JsonObject 中获得指定参数
     *
     * @param paramName 参数名称，
     * @return Integer 类型参数
     */
    public static Long getParamAsLong(JsonObject jsonObject, String paramName) {
        // jsonObject 为空或参数不存在
        if (jsonObject == null || !jsonObject.has(paramName)) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(paramName);

        // 参数值并非原始类型
        if (!jsonElement.isJsonPrimitive()) {
            LOGGER.warn("getParamAsInteger: 参数[" + paramName + "] 的值并非原始类型");
            return null;
        }
        JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();

        // 参数值并非String
        if (!jsonPrimitive.isNumber()) {
            LOGGER.warn("getParamAsInteger: 参数[" + paramName + "] 的值并非数字");
            return null;
        }

        return jsonPrimitive.getAsLong();
    }

    /**
     * 将对象序列化为Json字符串
     *
     * @param map 需要序列化的对象
     * @return 序列化后的Json字符串
     */
    public static String toJson(Map<String, Object> map) {
        return GSON.toJson(map);
    }

    /**
     * 将对象序列化为Json字符串
     *
     * @param jsonElement 需要序列化的对象
     * @return 序列化后的Json字符串
     */
    public static String toJson(JsonElement jsonElement) {
        return GSON.toJson(jsonElement);
    }
}


