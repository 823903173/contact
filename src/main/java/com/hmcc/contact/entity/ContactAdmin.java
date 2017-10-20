package com.hmcc.contact.entity;

import java.util.Date;

/**
 * Created by TR on 2017/10/17.
 */
public class ContactAdmin {

    private Integer managementNumber;

    private String organizationId;

    private Long contactNumber;

    private Integer state;

    private Date createTime;

    private Integer createAdminId;

    private Date lastModifiyTime;

    private Integer lastModifiyAdminId;

    private String extend1;

    private String extend2;

    private String extend3;

    private String extend4;

    public Integer getManagementNumber() {
        return managementNumber;
    }

    public void setManagementNumber(Integer managementNumber) {
        this.managementNumber = managementNumber;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateAdminId() {
        return createAdminId;
    }

    public void setCreateAdminId(Integer createAdminId) {
        this.createAdminId = createAdminId;
    }

    public Date getLastModifiyTime() {
        return lastModifiyTime;
    }

    public void setLastModifiyTime(Date lastModifiyTime) {
        this.lastModifiyTime = lastModifiyTime;
    }

    public Integer getLastModifiyAdminId() {
        return lastModifiyAdminId;
    }

    public void setLastModifiyAdminId(Integer lastModifiyAdminId) {
        this.lastModifiyAdminId = lastModifiyAdminId;
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3;
    }

    public String getExtend4() {
        return extend4;
    }

    public void setExtend4(String extend4) {
        this.extend4 = extend4;
    }

    @Override
    public String toString() {
        return "ContactAdmin{" +
                "managementNumber=" + managementNumber +
                ", organizationId=" + organizationId +
                ", contactNumber=" + contactNumber +
                ", state=" + state +
                ", createTime=" + createTime +
                ", createAdminId=" + createAdminId +
                ", lastModifiyTime=" + lastModifiyTime +
                ", lastModifiyAdminId=" + lastModifiyAdminId +
                ", extend1='" + extend1 + '\'' +
                ", extend2='" + extend2 + '\'' +
                ", extend3='" + extend3 + '\'' +
                ", extend4='" + extend4 + '\'' +
                '}';
    }
}
