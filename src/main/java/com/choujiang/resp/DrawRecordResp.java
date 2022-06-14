package com.choujiang.resp;

import lombok.Data;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawRecordResp
 * @Description 返回的单一签记录
 * @createTime 2022/06/14 16:22
 **/
@Data
public class DrawRecordResp {
    private Integer recordId;
    private Integer recordRand;
}
