package com.choujiang.req;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName OrganizationQueryReq
 * @Description
 * @createTime 2022/06/14 13:08
 **/
@Data
public class OrganizationQueryReq extends PageReq{
    private String orgName;
}
