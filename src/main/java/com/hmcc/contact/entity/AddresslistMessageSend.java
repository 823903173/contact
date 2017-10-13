package com.hmcc.contact.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 短信下发表
 * </p>
 *
 * @author chenhao
 * @since 2017-10-13
 */
@TableName("addresslist_message_send")
public class AddresslistMessageSend extends Model<AddresslistMessageSend> {

    private static final long serialVersionUID = 1L;

	@TableId(value="message_id", type= IdType.AUTO)
	private Integer messageId;
	@TableField("phone_num")
	private Long phoneNum;
	@TableField("send_time")
	private Date sendTime;
	@TableField("send_text")
	private String sendText;
	@TableField("send_status")
	private Integer sendStatus;
	@TableField("extended_field_1")
	private String extendedField1;
	@TableField("extended_field_2")
	private String extendedField2;
	@TableField("extended_field_3")
	private String extendedField3;
	@TableField("extended_field_4")
	private String extendedField4;


	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendText() {
		return sendText;
	}

	public void setSendText(String sendText) {
		this.sendText = sendText;
	}

	public Integer getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
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
		return this.messageId;
	}

	@Override
	public String toString() {
		return "AddresslistMessageSend{" +
			", messageId=" + messageId +
			", phoneNum=" + phoneNum +
			", sendTime=" + sendTime +
			", sendText=" + sendText +
			", sendStatus=" + sendStatus +
			", extendedField1=" + extendedField1 +
			", extendedField2=" + extendedField2 +
			", extendedField3=" + extendedField3 +
			", extendedField4=" + extendedField4 +
			"}";
	}
}
