package com.choujiang.resp;

import lombok.Data;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserLoginResp
 * @Description
 * @createTime 2022/06/14 12:38
 **/
@Data
public class UserLoginResp {
    private Integer userId;
    private String userName;
    private String token;
    private Integer userRole;
}
