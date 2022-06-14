package com.choujiang.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserLoginReq
 * @Description
 * @createTime 2022/06/14 10:57
 **/
@Data
public class UserLoginReq {
    @NotEmpty(message = "【用户名】不能为空")
    private String userName;
    @NotEmpty(message = "【密码】不能为空")
    // @Length(min = 6, max = 20, message = "【密码】6~20位")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】规则不正确")
    private String userPwd;
}
