package com.choujiang.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawRecordQueryReq
 * @Description 查询当次所有的签是否是中奖的, 如果没有recordid默认就会查询出，当前活动所有的签，有就查询出单一的签
 * @createTime 2022/06/15 14:48
 **/
@Data
public class DrawRecordQueryReq extends PageReq{
    private Integer recordId;

    private Integer recordRand;
    @NotNull(message = "\"[活动]不能为空\"")
    private Integer drawId;

}
