//package com.springboot.admin.xxs.RequestBodyXXS;
//
//import java.io.IOException;
//
//import com.fasterxml.jackson.core.Base64Variants;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonToken;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
//import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
//
//
////去掉注解，防止自定义反序列化器被认为是标准实现，从而反序列化String[] collection<String> Map<*, String> 无效
//// com.fasterxml.jackson.databind.util.ClassUtil.isJacksonStdImpl(Object)
////@JacksonStdImpl
//public class StringDeserializer extends StdScalarDeserializer<String> {
//    private static final long serialVersionUID = 1L;
//
//    public final static StringDeserializer instance = new StringDeserializer();
//
//    public StringDeserializer() {
//        super(String.class);
//    }
//
//    // since 2.6, slightly faster lookups for this very common type
//    @Override
//    public boolean isCachable() {
//        return true;
//    }
//
//    public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
//        JsonToken curr = jp.getCurrentToken();
//        if (curr == JsonToken.VALUE_STRING) {
//            return XssUtils.clean(jp.getText());
//        }
//
//        // Issue#381
//        if (curr == JsonToken.START_ARRAY && ctxt.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
//            jp.nextToken();
//            final String parsed = _parseString(jp, ctxt);
//            if (jp.nextToken() != JsonToken.END_ARRAY) {
//                throw ctxt.wrongTokenException(jp, JsonToken.END_ARRAY,
//                        "Attempted to unwrap single value array for single 'String' value but there was more than a single value in the array");
//            }
//            return XssUtils.clean(parsed);
//        }
//        // [JACKSON-330]: need to gracefully handle byte[] data, as base64
//        if (curr == JsonToken.VALUE_EMBEDDED_OBJECT) {
//            Object ob = jp.getEmbeddedObject();
//            if (ob == null) {
//                return null;
//            }
//            if (ob instanceof byte[]) {
//                return XssUtils.clean(Base64Variants.getDefaultVariant().encode((byte[]) ob, false));
//            }
//            // otherwise, try conversion using toString()...
//            return XssUtils.clean(ob.toString());
//        }
//        // allow coercions for other scalar types
//        String text = jp.getValueAsString();
//        if (text != null) {
//            return XssUtils.clean(text);
//        }
//        throw ctxt.mappingException(_valueClass, curr);
//    }
//
//    // Since we can never have type info ("natural type"; String, Boolean,
//    // Integer, Double):
//    // (is it an error to even call this version?)
//    @Override
//    public String deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
//            throws IOException {
//        return deserialize(p, ctxt);
//    }
//}