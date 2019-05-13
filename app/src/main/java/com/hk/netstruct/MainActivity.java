package com.hk.netstruct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String url = "https://api.github.com/users/he303954106";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, Object> map = new HashMap<>();

        HttpHelper.getInstance().post(url, map, new HttpCallBack<GitHubModel>() {
            @Override
            public void onSuccess(GitHubModel result) {
                Log.e("netResult", result.toString());
            }
        });
    }
}
