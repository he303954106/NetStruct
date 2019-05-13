package com.hk.netstruct;

import java.util.Map;

/**
 * Created by hk on 2019/5/13.
 */
public class HttpHelper implements IHttpProcessor {

    private HttpHelper() {
    }

    public static HttpHelper getInstance() {
        return HttpHelperHolder.INSTANCE;
    }

    private static class HttpHelperHolder {
        public static final HttpHelper INSTANCE = new HttpHelper();
    }

    private IHttpProcessor mIHttpProcessor;

    public void init(IHttpProcessor processor) {
        mIHttpProcessor = processor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        mIHttpProcessor.post(url, params, callBack);
    }
}
