package com.hmcc.contact.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * APP登录日志表
 * </p>
 *
 * @author chenhao
 * @since 2017-10-17
 */
@TableName("addresslist_app_login")
public class AddresslistAppLogin extends Model<AddresslistAppLogin> {

    private static final long serialVersionUID = 1L;

	@TableId(value="system_id", type= IdType.AUTO)
	private Integer systemId;
	@TableField("phone_num")
	private Long phoneNum;
	@TableField("login_time")
	private String loginTime;
	@TableField("login_result")
	private Integer loginResult;
	@TableField("phone_type")
	private String phoneType;
	@TableField("phone_imei")
	private String phoneImei;
	@TableField("extended_field_1")
	private String extendedField1;
	@TableField("extended_field_2")
	private String extendedField2;
	@TableField("extended_field_3")
	private String extendedField3;
	@TableField("extended_field_4")
	private String extendedField4;


	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(Integer loginResult) {
		this.loginResult = loginResult;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneImei() {
		return phoneImei;
	}

	public void setPhoneImei(String phoneImei) {
		this.phoneImei = phoneImei;
	}

	public String getExtendedField1() {
		return extendedField1;
	}

	public void setExtendedField1(String extendedField1) {
		this.extendedField1 = extendedField1;
	}

	public String getExtendedField2() {
		return extendedField2;
	}

	public void setExtendedField2(String extendedField2) {
		this.extendedField2 = extendedField2;
	}

	public String getExtendedField3() {
		return extendedField3;
	}

	public void setExtendedField3(String extendedField3) {
		this.extendedField3 = extendedField3;
	}

	public String getExtendedField4() {
		return extendedField4;
	}

	public void setExtendedField4(String extendedField4) {
		this.extendedField4 = extendedField4;
	}

	@Override
	protected Serializable pkVal() {
		return this.systemId;
	}

	@Override
	public String toString() {
		return "AddresslistAppLogin{" +
			", systemId=" + systemId +
			", phoneNum=" + phoneNum +
			", loginTime=" + loginTime +
			", loginResult=" + loginResult +
			", phoneType=" + phoneType +
			", phoneImei=" + phoneImei +
			", extendedField1=" + extendedField1 +
			", extendedField2=" + extendedField2 +
			", extendedField3=" + extendedField3 +
			", extendedField4=" + extendedField4 +
			"}";
	}
}
