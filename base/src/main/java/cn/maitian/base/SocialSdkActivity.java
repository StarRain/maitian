package cn.maitian.base;

import android.os.Bundle;

import cn.maitian.eventbus.EventUtil;
import cn.maitian.social_sdk.SocialSdk;

/**
 *
 */
public class SocialSdkActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventUtil.register(this);
        SocialSdk.initProgressDialog(this, "", "加载中...");
    }

}