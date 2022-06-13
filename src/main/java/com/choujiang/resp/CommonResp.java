package com.choujiang.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName CommonResp
 * @Description 通用的数据返回类
 * @createTime 2022/06/13 22:28
 **/
@Data
@NoArgsConstructor
public class CommonResp<T> {
    private boolean success = true;
    private String message;
    private T content;
    public CommonResp(String message, T content) {
        this.message = message;
        this.content = content;
    }
}
