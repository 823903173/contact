package com.hmcc.contact.entity;

import java.util.Date;

/**
 * Created by TR on 2017/10/18.
 */
public class ContactOrg {
    private String  id;

    private String parentId;

    private String name;

    private Integer level;

    private Integer status;

    private Date createTime;

    private Integer managerId;

    private Date lastModifiyTime;

    private Integer lastModifiyManagerId;

    private String extend1;

    private String extend2;

    private String extend3;

    private String extend4;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Date getLastModifiyTime() {
        return lastModifiyTime;
    }

    public void setLastModifiyTime(Date lastModifiyTime) {
        this.lastModifiyTime = lastModifiyTime;
    }

    public Integer getLastModifiyManagerId() {
        return lastModifiyManagerId;
    }

    public void setLastModifiyManagerId(Integer lastModifiyManagerId) {
        this.lastModifiyManagerId = lastModifiyManagerId;
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
        return "ContactOrg{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", status=" + status +
                ", createTime=" + createTime +
                ", managerId=" + managerId +
                ", lastModifiyTime=" + lastModifiyTime +
                ", lastModifiyManagerId=" + lastModifiyManagerId +
                ", extend1='" + extend1 + '\'' +
                ", extend2='" + extend2 + '\'' +
                ", extend3='" + extend3 + '\'' +
                ", extend4='" + extend4 + '\'' +
                '}';
    }
}
