package com.choujiang.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserSaveReq
 * @Description 添加用户
 * @createTime 2022/06/14 9:30
 **/
@Data
public class UserSaveReq {
    private Integer userId;
    @NotNull(message = "【用户名】不能为空")
    private String userName;
    @NotNull(message = "【密码】不能为空")
    // @Length(min = 6, max = 20, message = "【密码】6~20位")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】至少包含 数字和英文，长度6-32")
    private String userPwd;
    private String orgCode;
    private Integer userRole;
}
