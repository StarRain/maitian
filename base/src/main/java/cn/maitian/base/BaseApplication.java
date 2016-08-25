package cn.maitian.base;


import cn.maitian.multidex.MultiDexApplication;
import cn.maitian.retrofit_api.RetrofitApi;
import cn.maitian.retrofit_api.RetrofitApiUtil;
import cn.maitian.retrofit_api.RetrofitUtils;
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
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public RetrofitApi getRetrofitApi() {
        return mRetrofitApi;
    }
}
