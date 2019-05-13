package com.hk.netstruct;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by hk on 2019/5/13.
 */
public class OkHttpProcessor implements IHttpProcessor {

    private final OkHttpClient mOkHttpClient;

    public OkHttpProcessor() {
        mOkHttpClient = new OkHttpClient();
    }

    @Override
    public void post(String url, Map<String, Object> params, final ICallBack callBack) {
        RequestBody requestBody = appendBody(params);
        // TODO: 2019/5/13
        //        Request request = new Request.Builder().url(url).post(requestBody).build();
        Request request = new Request.Builder().url(url).get().build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    callBack.onSuccess(response.body().string());
                }
            }
        });
    }

    private RequestBody appendBody(Map<String, Object> params) {
        FormBody.Builder body = new FormBody.Builder();
        if (params == null || params.isEmpty()) {
            return body.build();
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            body.add(entry.getKey(), entry.getValue().toString());
        }
        return body.build();
    }
}
