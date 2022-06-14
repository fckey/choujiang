package com.choujiang.req;

import lombok.Data;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawRecordReq
 * @Description 表示对签的操作
 * @createTime 2022/06/14 17:19
 **/
@Data
public class DrawRecordReq {
    private Integer recordId;
    private Integer drawId;
    private Integer recordRand;
    private Integer status;
}
