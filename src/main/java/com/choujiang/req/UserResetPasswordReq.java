package com.choujiang.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserResetPasswordReq
 * @Description
 * @createTime 2022/06/14 11:18
 **/
@Data
public class UserResetPasswordReq {
    private Integer userId;
    @NotNull(message = "【密码】不能为空")
    // @Length(min = 6, max = 20, message = "【密码】6~20位")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】至少包含 数字和英文，长度6-32")
    private String userPwd;
}
