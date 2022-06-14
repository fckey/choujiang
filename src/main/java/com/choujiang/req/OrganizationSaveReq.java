package com.choujiang.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName OrganizationSaveReq
 * @Description
 * @createTime 2022/06/14 13:22
 **/
@Data
public class OrganizationSaveReq {
    private Integer orgCode;
    @NotNull(message = "【组织名称】不能为空")
    private String orgName;
    @Min(value = 0, message = "不能为负数")
    private Integer orgQuota;
    private Integer orgJoined;
}
