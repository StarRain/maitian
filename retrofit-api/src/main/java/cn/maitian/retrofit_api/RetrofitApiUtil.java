package cn.maitian.retrofit_api;

import retrofit2.Retrofit;

/**
 * Created by geng on 2016/8/2.
 */
public class RetrofitApiUtil {
    public static RetrofitApi createRetrofitApi(Retrofit retrofit) {
        return retrofit.create(RetrofitApi.class);
    }
}
