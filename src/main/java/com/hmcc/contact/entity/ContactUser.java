package com.hmcc.contact.entity;


import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by LiZhengTao on 2017/10/12.
 */
public class ContactUser {
    private Integer userId;

    private String userName;

    private Integer userGender;

    private String groupId;

    private String userJob;

    private Long phoneNum;

    private Integer isHidden;

    private String userPosition;

    private Integer userStatus;

    private Date createTime;

    private String createManagerId;

    private Date latestReviseTime;

    private String latestReviseManagerId;

    private String showOrder;

    private String extendedField1;

    private String extendedField2;

    private String extendedField3;

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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
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
    public String toString() {
        return "ContactUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userGender=" + userGender +
                ", groupId=" + groupId +
                ", userJob='" + userJob + '\'' +
                ", phoneNum=" + phoneNum +
                ", isHidden=" + isHidden +
                ", userPosition='" + userPosition + '\'' +
                ", userStatus=" + userStatus +
                ", createTime=" + createTime +
                ", createManagerId='" + createManagerId + '\'' +
                ", latestReviseTime='" + latestReviseTime + '\'' +
                ", latestReviseManagerId='" + latestReviseManagerId + '\'' +
                ", showOrder='" + showOrder + '\'' +
                ", extendedField1='" + extendedField1 + '\'' +
                ", extendedField2='" + extendedField2 + '\'' +
                ", extendedField3='" + extendedField3 + '\'' +
                ", extendedField4='" + extendedField4 + '\'' +
                '}';
    }
}
