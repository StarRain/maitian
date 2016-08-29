package cn.maitian.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.maitian.analytics.AnalyticsUtil;
import cn.maitian.eventbus.EventUtil;
import cn.maitian.eventbus.event.BaseEvent;
import cn.maitian.retrofit_api.RetrofitApi;

/**
 *
 */
public class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();
    private RetrofitApi mRetrofitApi;

    public RetrofitApi getRetrofitApi() {
        return mRetrofitApi;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventUtil.register(this);
        mRetrofitApi = BaseApplication.getBaseApplication().getRetrofitApi();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AnalyticsUtil.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AnalyticsUtil.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventUtil.unregister(this);
    }

    // This method will be called when a BaseEvent is posted (in the UI thread for Toast)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(BaseEvent event) {
    }

    public void postEvent(Object event) {
        EventUtil.postEvent(event);
    }
}