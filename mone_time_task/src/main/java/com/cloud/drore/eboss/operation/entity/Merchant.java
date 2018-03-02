package com.cloud.drore.eboss.operation.entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.drore.eboos.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

/**
 * 浙江卓锐科技股份有限公司 版权所有  Copyright 2018<br>
 *
 * @Description: 商户实体类<br>
 * @Project: eboos <br>
 * @CreateDate: Created in 2018/1/5 0005 下午 6:12 <br>
 * @Author: <a href="410508961@qq.com">夏凯</a>
 */
@Table(name = "eboos_merchant")
@Data
public class Merchant extends BaseEntity<Long> {

    /**
     * 商户名称
     */
    @NotBlank(message = "商户名称不能为空！")
    @JsonProperty("merchant_name")
    @JSONField(name = "merchant_name")
    @ApiModelProperty(name = "merchant_name", notes = "商户名称", example = "西溪湿地")
    private String merchantName;
    /**
     * 商户类型
     */
    @NotNull(message = "商户类型不能为空")
    @JsonProperty("merchant_type")
    @JSONField(name = "merchant_type")
    @ApiModelProperty(name = "merchant_type", notes = "商户类型", example = "MERCHANT_SUPPLIER")
    private String merchantType;

    /**
     * 商户性质
     */
    @NotNull(message = "商户性质不能为空")
    @JsonProperty("merchant_character")
    @JSONField(name = "merchant_character")
    @ApiModelProperty(name = "merchant_character", notes = "商户性质", example = "MERCHANT_CHARACTER_PERSON")
    private String merchantCharacter;

    /**
     * 商户行业
     */
    @NotNull(message = "商户行业不能为空")
    @JsonProperty("merchant_industry")
    @JSONField(name = "merchant_industry")
    @ApiModelProperty(name = "merchant_industry", notes = "商户行业", example = "MERCHANT_INDUSTRY_SCENIC")
    private String merchantIndustry;

    /**
     * 销售产品类型
     */
    @NotNull(message = "销售产品类型不能为空！")
    @Transient
    @JsonProperty("goods_sale_type")
    @JSONField(name = "goods_sale_type")
    private List<String> goodsSaleType;

    /**
     * 联系人
     */
    @NotBlank(message = "联系人不能为空！")
    @JsonProperty("link_man")
    @JSONField(name = "link_man")
    @ApiModelProperty(name = "link_man", notes = "联系人", example = "冯腾")
    private String linkMan;

    /**
     * 联系人手机号
     */
    @NotBlank(message = "联系人手机号不能为空！")
    @JsonProperty("mobile")
    @JSONField(name = "mobile")
    @ApiModelProperty(name = "mobile", notes = "联系人手机号", example = "18072750743")
    private String mobile;

    /**
     * 联系电话
     */
    @JsonProperty("telephone")
    @JSONField(name = "telephone")
    @ApiModelProperty(name = "telephone", notes = "联系电话", example = "0571-57642301")
    private String telephone;

    /**
     * 邮箱地址
     */
    @Email
    @JsonProperty("email_address")
    @JSONField(name = "email_address")
    @ApiModelProperty(name = "email_address", notes = "邮箱地址", example = "8888888@qq.com")
    private String emailAddress;

    /**
     * 通讯地址省
     */
    @NotBlank(message = "通讯地址省不能为空！")
    @JsonProperty("postal_address_province")
    @JSONField(name = "postal_address_province")
    @ApiModelProperty(name = "postal_address_province", notes = "通讯地址省", example = "浙江省")
    private String postalAddressProvince;

    /**
     * 通讯地址市
     */
    @NotBlank(message = "通讯地址市不能为空！")
    @JsonProperty("postal_address_city")
    @JSONField(name = "postal_address_city")
    @ApiModelProperty(name = "postal_address_city", notes = "通讯地址市", example = "杭州市")
    private String postalAddressCity;

    /**
     * 通讯地址县
     */
    @NotBlank(message = "通讯地址县不能为空！")
    @JsonProperty("postal_address_county")
    @JSONField(name = "postal_address_county")
    @ApiModelProperty(name = "postal_address_county", notes = "通讯地址县", example = "建德县")
    private String postalAddressCounty;

    /**
     * 详细地址
     */
    @JsonProperty("detail_address")
    @JSONField(name = "detail_address")
    @ApiModelProperty(name = "detail_address", notes = "详细地址", example = "龙舌嘴西溪湿地")
    private String detailAddress;

    /**
     * 营业执照照片
     */
    @Null(message = "营业执照照片不能替换！", groups = Merchant.SAVE.class)
    @JsonProperty("business_license_url")
    @JSONField(name = "business_license_url")
    @ApiModelProperty(name = "business_license_url", notes = "营业执照照片", example = "business_license_url")
    private String businessLicenseUrl;


    /**
     * 合同有效开始日期
     */
    @Null(message = "合同有效开始日期不能替换！", groups = Merchant.SAVE.class)
    @NotNull(message = "合同有效开始日期不能为空")
    @JsonProperty("binding_contract_start")
    @JSONField(name = "binding_contract_start", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "binding_contract_start", notes = "合同有效开始日期", example = "2018-01-01")
    private Date bindingContractStart;

    /**
     * 合同有效截止日期
     */
    @Null(message = "合同有效截止日期不能替换！", groups = Merchant.SAVE.class)
    @NotNull(message = "合同有效截止日期不能为空")
    @JsonProperty("binding_contract_end")
    @JSONField(name = "binding_contract_end", format = "yyyy-MM-dd")
    @ApiModelProperty(name = "binding_contract_end", notes = "合同有效截止日期", example = "2018-09-01")
    private Date bindingContractEnd;

    /**
     * 合同附件
     */
    @Null(message = "合同附件不能替换！", groups = Merchant.SAVE.class)
    @JsonProperty("contract_attachment")
    @JSONField(name = "contract_attachment")
    @ApiModelProperty(name = "contract_attachment", notes = "合同附件", example = "contract_attachment")
    private String contractAttachment;

    /**
     * 商户审核状态
     */
    @JsonProperty("merchant_state")
    @JSONField(name = "merchant_state")
    @ApiModelProperty(name = "merchant_state", notes = "商户审核状态", example = "MERCHANT_AUDIT_ALREADY(新增商户的时候不需要上传字段)")
    private String merchantState;
    /**
     * 商户管理员
     */
    @Null(message = "商户管理员不需要上传")
    @JsonProperty("merchant_manager")
    @JSONField(name = "merchant_manager")
    @ApiModelProperty(name = "merchant_manager", notes = "商户管理员", example = "12")
    private Long merchantManager;

    /**
     * 商户编号
     */
    @Null(message = "商户编号字段不需要，后台生成！")
    @JsonProperty("merchant_num")
    @JSONField(name = "merchant_num")
    @ApiModelProperty(name = "merchant_num", notes = "商户编号", example = "DISTRIBUTE83")
    private String merchantNum;


    /**
     * 商户状态code翻译成name
     */
    @Transient
    @JsonProperty("merchant_state_code_to_name")
    @JSONField(name = "merchant_state_code_to_name")
    @ApiModelProperty(name = "merchant_state_code_to_name", notes = "商户状态code翻译成name", example = "只显示用，用于字典进行翻译户状态")
    private String merchantStateCodeToName;
    /**
     * 商户管理员姓名
     */
    @Transient
    private String merchantManage;

    public interface SAVE {

    }
}