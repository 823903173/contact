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
 * 个人信息表
 * </p>
 *
 * @author CuiYong
 * @since 2017-09-27
 */
@TableName("addresslist_user")
public class AddresslistUser extends Model<AddresslistUser> {

    private static final long serialVersionUID = 1L;

	@TableId(value="user_id", type= IdType.AUTO)
	private Integer userId;
	@TableField("user_name")
	private String userName;
	@TableField("user_gender")
	private Integer userGender;
	@TableField("group_id")
	private Integer groupId;
	@TableField("user_job")
	private String userJob;
	@TableField("phone_num")
	private Long phoneNum;
	@TableField("is_hidden")
	private Integer isHidden;
	@TableField("user_position")
	private String userPosition;
	@TableField("user_status")
	private Integer userStatus;
	@TableField("create_time")
	private Date createTime;
	@TableField("create_manager_id")
	private String createManagerId;
	@TableField("latest_revise_time")
	private Date latestReviseTime;
	@TableField("latest_revise_manager_id")
	private String latestReviseManagerId;
	@TableField("show_order")
	private String showOrder;
	@TableField("extended_field_1")
	private String extendedField1;
	@TableField("extended_field_2")
	private String extendedField2;
	@TableField("extended_field_3")
	private String extendedField3;
	@TableField("extended_field_4")
	private String extendedField4;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserGender() {
		return userGender;
	}

	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getUserJob() {
		return userJob;
	}

	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Integer isHidden) {
		this.isHidden = isHidden;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateManagerId() {
		return createManagerId;
	}

	public void setCreateManagerId(String createManagerId) {
		this.createManagerId = createManagerId;
	}

	public Date getLatestReviseTime() {
		return latestReviseTime;
	}

	public void setLatestReviseTime(Date latestReviseTime) {
		this.latestReviseTime = latestReviseTime;
	}

	public String getLatestReviseManagerId() {
		return latestReviseManagerId;
	}

	public void setLatestReviseManagerId(String latestReviseManagerId) {
		this.latestReviseManagerId = latestReviseManagerId;
	}

	public String getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(String showOrder) {
		this.showOrder = showOrder;
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
		return this.userId;
	}

	@Override
	public String toString() {
		return "AddresslistUser{" +
			", userId=" + userId +
			", userName=" + userName +
			", userGender=" + userGender +
			", groupId=" + groupId +
			", userJob=" + userJob +
			", phoneNum=" + phoneNum +
			", isHidden=" + isHidden +
			", userPosition=" + userPosition +
			", userStatus=" + userStatus +
			", createTime=" + createTime +
			", createManagerId=" + createManagerId +
			", latestReviseTime=" + latestReviseTime +
			", latestReviseManagerId=" + latestReviseManagerId +
			", showOrder=" + showOrder +
			", extendedField1=" + extendedField1 +
			", extendedField2=" + extendedField2 +
			", extendedField3=" + extendedField3 +
			", extendedField4=" + extendedField4 +
			"}";
	}
}
