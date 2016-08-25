package cn.maitian.base;


import android.content.Context;
import android.support.v4.app.Fragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.maitian.eventbus.EventUtil;
import cn.maitian.eventbus.event.BaseEvent;
import cn.maitian.retrofit_api.RetrofitApi;

/**
 *
 */
public class BaseFragment extends Fragment {
    private BaseActivity mBaseActivity;
    private RetrofitApi mRetrofitApi;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mBaseActivity = (BaseActivity) context;
        mRetrofitApi = mBaseActivity.getRetrofitApi();
        EventUtil.register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventUtil.unregister(this);
    }

    // This method will be called when a BaseEvent is posted (in the UI thread for Toast)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(BaseEvent event) {
    }

    public void postEvent(Object event) {
        EventUtil.postEvent(event);
    }

    public BaseActivity getBaseActivity() {
        return mBaseActivity;
    }

    public RetrofitApi getRetrofitApi() {
        return mRetrofitApi;
    }
}
