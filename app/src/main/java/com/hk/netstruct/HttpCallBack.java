package com.hk.netstruct;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by hk on 2019/5/13.
 */
public abstract class HttpCallBack<T> implements ICallBack {
    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();

        Class<?> clazz = analysisClassInfo(this);

        T objectResult = (T) gson.fromJson(result, clazz);

        onSuccess(objectResult);
    }

    private Class<?> analysisClassInfo(Object obj) {
        Type genType = obj.getClass().getGenericSuperclass();
        Type[] actualType = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) actualType[0];
    }

    public abstract void onSuccess(T result);

    @Override
    public void onFail() {

    }
}
