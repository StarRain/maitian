package cn.maitian.base;

import android.content.Intent;
import android.os.Bundle;

import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import cn.maitian.social_sdk.SocialSdk;

/**
 * 获取平台信息的Activity
 */
public class SocialPlatformInfoActivity extends BaseActivity {
    private static final String TAG = SocialPlatformInfoActivity.class.getSimpleName();
    private SocialSdk.SocialAuthSdkHandler mGetPlatformInfoHandler;
    private final SocialSdk.SocialAuthSdkHandler mAuthHandler = new SocialSdk.SocialAuthSdkHandler() {
        @Override
        public void onComplete(SHARE_MEDIA share_media, int action, Map<String, String> map) {
            if (share_media == SHARE_MEDIA.QQ) {
                doGetPlatformInfoQQ(mGetPlatformInfoHandler);
            } else if (share_media == SHARE_MEDIA.WEIXIN) {
                doGetPlatformInfoWeiXin(mGetPlatformInfoHandler);
            } else if (share_media == SHARE_MEDIA.SINA) {
                doGetPlatformInfoSina(mGetPlatformInfoHandler);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SocialSdk.init();
        SocialSdk.setSinaWeibo(BuildConfig.SINA_APPKEY, BuildConfig.SINA_SECRET);
        SocialSdk.setWeixin(BuildConfig.WEIXIN_APPID, BuildConfig.WEIXIN_SECRET);
        SocialSdk.setQQZone(BuildConfig.QQ_APPID, BuildConfig.QQ_SECRET);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SocialSdk.onActivityResult(this, requestCode, resultCode, data);
    }

    private void doOauthVerifySina(SocialSdk.SocialAuthSdkHandler handler) {
        SocialSdk.doOauthVerify(this, SHARE_MEDIA.SINA, handler);
    }

    private void doOauthVerifyWeiXin(SocialSdk.SocialAuthSdkHandler handler) {
        SocialSdk.doOauthVerify(this, SHARE_MEDIA.WEIXIN, handler);
    }

    private void doOauthVerifyQQ(SocialSdk.SocialAuthSdkHandler handler) {
        SocialSdk.doOauthVerify(this, SHARE_MEDIA.QQ, handler);
    }

    private void doGetPlatformInfoSina(SocialSdk.SocialAuthSdkHandler handler) {
        SocialSdk.getPlatformInfo(this, SHARE_MEDIA.SINA, handler);
    }

    private void doGetPlatformInfoWeiXin(SocialSdk.SocialAuthSdkHandler handler) {
        SocialSdk.getPlatformInfo(this, SHARE_MEDIA.WEIXIN, handler);
    }

    private void doGetPlatformInfoQQ(SocialSdk.SocialAuthSdkHandler handler) {
        SocialSdk.getPlatformInfo(this, SHARE_MEDIA.QQ, handler);
    }

    public void getPlatformInfoSina(SocialSdk.SocialAuthSdkHandler handler) {
        mGetPlatformInfoHandler = handler;
        doOauthVerifySina(mAuthHandler);
    }

    public void getPlatformInfoWeiXin(SocialSdk.SocialAuthSdkHandler handler) {
        mGetPlatformInfoHandler = handler;
        doOauthVerifyWeiXin(mAuthHandler);
    }

    public void getPlatformInfoQQ(SocialSdk.SocialAuthSdkHandler handler) {
        mGetPlatformInfoHandler = handler;
        doOauthVerifyQQ(mAuthHandler);
    }
}