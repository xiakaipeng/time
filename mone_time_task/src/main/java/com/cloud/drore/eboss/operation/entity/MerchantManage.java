package com.cloud.drore.eboss.operation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 商户管理员实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/8 0008 下午 2:06 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Table(name = "eboos_merchant_manage")
@Data
public class MerchantManage extends BaseEntity<Long> {
    /**
     * 登录账号
     */
    @NotBlank(message = "登录账号不能为空！")
    @JsonProperty("account_user")
    @JSONField(name = "account_user")

    @ApiModelProperty(name = "account_user", notes = "登录账号", example = "xiakai")
    private String accountUser;

    /**
     * 登录密码
     */
    @NotBlank(message = "登录密码不能为空！")
    @JsonProperty("account_pwd")
    @JSONField(name = "account_pwd")
    @ApiModelProperty(name = "account_pwd", notes = "登录密码", example = "123456")
    private String accountPwd = "123456";

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空！")
    @JsonProperty("account_name")
    @JSONField(name = "account_name")
    @ApiModelProperty(name = "account_name", notes = "姓名", example = "夏凯")
    private String accountName;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空！")
    @JsonProperty("account_tel")
    @JSONField(name = "account_tel")
    @ApiModelProperty(name = "account_tel", notes = "手机号码", example = "18888888888")
    private String accountTel;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空！")
    @JsonProperty("account_email")
    @JSONField(name = "account_email")
    @ApiModelProperty(name = "account_email", notes = "邮箱", example = "xiakai@qq.com")
    private String accountEmail;

    /**
     * 头像地址
     */
    @NotBlank(message = "头像地址不能为空！")
    @JsonProperty("account_top_mapurl")
    @JSONField(name = "account_top_mapurl")
    @ApiModelProperty(name = "account_top_mapurl", notes = "头像地址", example = "account_top_mapurl")
    private String accountTopMapurl;

    /**
     * 商户id
     */
    @NotNull(message = "商户id不能为空！")
    @JsonProperty("merchant_id")
    @JSONField(name = "merchant_id")
    @ApiModelProperty(name = "merchant_id", notes = "商户id", example = "17")
    private Long merchantId;

}
