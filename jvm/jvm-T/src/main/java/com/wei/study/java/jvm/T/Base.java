package com.wei.study.java.jvm.T;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class Base<T> {

    public T getT() {
        String json = "{\"name\":\"张三\", \"age\":12}";
        T t = JSON.parseObject(json, getTClass());
        return t;
    }

    public Class<T> getTClass() {
        Type type = getClass().getGenericSuperclass();
        return (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }

}
