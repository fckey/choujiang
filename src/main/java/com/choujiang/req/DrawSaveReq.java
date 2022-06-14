package com.choujiang.req;

import lombok.Data;

import java.util.List;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName DrawSaveReq
 * @Description 新建一个活动所需要的接口
 * @createTime 2022/06/14 15:24
 **/
@Data
public class DrawSaveReq {
    private Integer drawId;

    private String drawDesc;
    // 当前活动参与的企业
    private List<Integer> orgs;

    private Integer drawLuck;
}
