package com.choujiang.resp;

import lombok.Data;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName Draw
 * @Description
 * @createTime 2022/06/14 16:36
 **/
@Data
public class DrawQueryResp {
    private Integer drawId;
    private String drawDesc;
    private Integer drawNum;
    private Integer drawLuck;
}
