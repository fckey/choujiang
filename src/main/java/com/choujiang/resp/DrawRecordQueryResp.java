package com.choujiang.resp;

import lombok.Data;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawRecordQueryResp
 * @Description 查询当前签的状态
 * @createTime 2022/06/15 14:58
 **/
@Data
public class DrawRecordQueryResp {
    private Integer recordId;
    private Integer drawId;
    private Integer recordRand;
    private Integer recordStatus; // 改签是否中
    private Integer date; // 抽的日期
}
