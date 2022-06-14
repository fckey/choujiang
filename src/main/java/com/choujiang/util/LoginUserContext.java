package com.choujiang.util;

import com.choujiang.resp.UserLoginResp;
import com.choujiang.resp.UserQueryResp;

import java.io.Serializable;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName LoginUserContext
 * @Description
 * @createTime 2022/06/14 11:25
 **/
public class LoginUserContext implements Serializable {
    private static ThreadLocal<UserLoginResp> user = new ThreadLocal<>();

    public static UserLoginResp getUser() {
        return user.get();
    }

    public static void setUser(UserLoginResp user) {
        LoginUserContext.user.set(user);
    }
}
