package com.choujiang.req;

import lombok.Data;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawQueryReq
 * @Description
 * @createTime 2022/06/14 16:32
 **/
@Data
public class DrawQueryReq extends PageReq{
    private String drawDesc;
}
