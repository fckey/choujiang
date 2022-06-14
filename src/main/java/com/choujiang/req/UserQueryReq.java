package com.choujiang.req;

import lombok.Data;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName UserQueryReq
 * @Description
 * @createTime 2022/06/14 9:56
 **/
@Data
public class UserQueryReq extends PageReq{
    private String username;
}
