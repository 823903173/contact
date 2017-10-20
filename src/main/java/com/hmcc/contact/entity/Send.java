package com.hmcc.contact.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 */
public class Send extends Model<Send> {

    private static final long serialVersionUID = 1L;

	@TableId(value="system_Id", type= IdType.AUTO)
	private Integer systemId;
	@TableField("phone_Number")
	private Long phoneNumber;
	@TableField("verify_code")
	private String verifyCode;
	@TableField("text")
	private String text;



	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	protected Serializable pkVal() {
		return this.systemId;
	}

	@Override
	public String toString() {
		return "Send{" +
			", systemId=" + systemId +
			", phoneNumber=" + phoneNumber +
			", verifyCode=" + verifyCode +
			", text=" + text +
			"}";
	}
}
