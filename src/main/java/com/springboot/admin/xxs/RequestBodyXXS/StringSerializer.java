//package com.springboot.admin.xxs.RequestBodyXXS;
//
//import java.io.IOException;
//import java.lang.reflect.Type;
//
//import com.fasterxml.jackson.core.*;
//
//import com.fasterxml.jackson.databind.JavaType;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
//import com.fasterxml.jackson.databind.ser.std.NonTypedScalarSerializerBase;
//
///**
// * This is the special serializer for regular {@link java.lang.String}s.
// *<p>
// * Since this is one of "native" types, no type information is ever
// * included on serialization (unlike for most scalar types as of 1.5)
// */
//public final class StringSerializer extends NonTypedScalarSerializerBase<String> {
//    private static final long serialVersionUID = 1L;
//
//    public static final StringSerializer instance = new StringSerializer();
//
//    public StringSerializer() {
//        super(String.class);
//    }
//
//    /**
//     * For Strings, both null and Empty String qualify for emptiness.
//     */
//    @Override
//    @Deprecated
//    public boolean isEmpty(String value) {
//        return (value == null) || (value.length() == 0);
//    }
//
//    @Override
//    public boolean isEmpty(SerializerProvider prov, String value) {
//        return (value == null) || (value.length() == 0);
//    }
//
//    @Override
//    public void serialize(String value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
//        jgen.writeString(XssUtils.clean(value));
//    }
//
//    @Override
//    public JsonNode getSchema(SerializerProvider provider, Type typeHint) {
//        return createSchemaNode("string", true);
//    }
//
//    @Override
//    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint)
//            throws JsonMappingException {
//        if (visitor != null)
//            visitor.expectStringFormat(typeHint);
//    }
//}
