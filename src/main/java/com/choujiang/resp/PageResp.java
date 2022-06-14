package com.choujiang.resp;

import lombok.Data;

import java.util.List;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName PageResp
 * @Description
 * @createTime 2022/06/14 10:04
 **/
@Data
public class PageResp <T>{
    private long total;
    private List<T> list;
}
