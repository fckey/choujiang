package com.choujiang.resp;

import com.choujiang.domain.Organization;
import lombok.Data;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserQueryResp
 * @Description
 * @createTime 2022/06/14 10:00
 **/
@Data
public class UserQueryResp {
    private Integer userId;
    private String userName;
    private String userPwd;
    private Organization organization;
    private Integer userRole;
}
