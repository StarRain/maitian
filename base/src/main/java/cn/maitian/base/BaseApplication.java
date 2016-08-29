package cn.maitian.base;


import cn.maitian.multidex.MultiDexApplication;
import cn.maitian.retrofit_api.RetrofitApi;
import cn.maitian.retrofit_api.RetrofitApiUtil;
import cn.maitian.retrofit_api.RetrofitUtils;
import cn.maitian.social_sdk.SocialSdk;
import retrofit2.Retrofit;

/**
 *
 */
public class BaseApplication extends MultiDexApplication {
    private static BaseApplication sBaseApplication;
    private Retrofit mRetrofit;
    private RetrofitApi mRetrofitApi;

    public static BaseApplication getBaseApplication() {
        return sBaseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApplication = this;
        mRetrofit = RetrofitUtils.initClient(this, BuildConfig.BASE_URL, BuildConfig.APPLICATION_ID, BuildConfig.FLAVOR, BuildConfig.VERSION_NAME, String.valueOf(cn.maitian.multidex.BuildConfig.VERSION_CODE));
        mRetrofitApi = RetrofitApiUtil.createRetrofitApi(mRetrofit);
        initSocial();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public RetrofitApi getRetrofitApi() {
        return mRetrofitApi;
    }

    private void initSocial() {
        SocialSdk.init();
        SocialSdk.setSinaWeibo(BuildConfig.SINA_APPKEY, BuildConfig.SINA_SECRET);
        SocialSdk.setWeixin(BuildConfig.WEIXIN_APPID, BuildConfig.WEIXIN_SECRET);
        SocialSdk.setQQZone(BuildConfig.QQ_APPID, BuildConfig.QQ_SECRET);
    }
}
