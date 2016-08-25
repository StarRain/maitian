package cn.maitian.api;

import cn.maitian.api.base.DataResponse;
import cn.maitian.api.bean.UserBean;

public interface Api {
    String DEVELOPING_URL = "http://xxx";
    String RELEASE_URL = "http://xxx";
    String USER_PATH = "/user";

    /**
     * @param userId
     * @return
     */
    DataResponse<UserBean> getUserByUserId(String userId);
}