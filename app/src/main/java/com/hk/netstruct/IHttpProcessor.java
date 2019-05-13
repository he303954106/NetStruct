package com.hk.netstruct;

import java.util.Map;

/**
 * Created by hk on 2019/5/13.
 */
public interface IHttpProcessor {

    void post(String url, Map<String,Object> params,ICallBack callBack);
}
