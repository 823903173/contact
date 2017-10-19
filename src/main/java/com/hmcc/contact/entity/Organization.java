package com.hmcc.contact.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenhao
 * @since 2017-10-19
 */
@TableName("Organization")
public class Organization extends Model<Organization> {

    private static final long serialVersionUID = 1L;

	@TableId(value="auto_id", type= IdType.AUTO)
	private Integer autoId;
    /**
     * "组织ID—Group_Id"
     */
	@TableField("id")
	private String id;
	@TableField("parent_id")
	private String parentId;
	private String name;
	private Integer level;
	private Integer status;
	@TableField("create_time")
	private String createTime;
	@TableField("manager_id")
	private Integer managerId;
	@TableField("last_modify_time")
	private String lastModifyTime;
	@TableField("last_modify_manager_id")
	private Integer lastModifyManagerId;
	private String ext1;
	private String ext2;
	private String ext3;
    /**
     * 部门组织表
     */
	private String ext4;


	public Integer getAutoId() {
		return autoId;
	}

	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
	}

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getLastModifyManagerId() {
		return lastModifyManagerId;
	}

	public void setLastModifyManagerId(Integer lastModifyManagerId) {
		this.lastModifyManagerId = lastModifyManagerId;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getExt3() {
		return ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	public String getExt4() {
		return ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	@Override
	protected Serializable pkVal() {
		return this.autoId;
	}

	@Override
	public String toString() {
		return "Organization{" +
			", autoId=" + autoId +
			", id=" + id +
			", parentId=" + parentId +
			", name=" + name +
			", level=" + level +
			", status=" + status +
			", createTime=" + createTime +
			", managerId=" + managerId +
			", lastModifyTime=" + lastModifyTime +
			", lastModifyManagerId=" + lastModifyManagerId +
			", ext1=" + ext1 +
			", ext2=" + ext2 +
			", ext3=" + ext3 +
			", ext4=" + ext4 +
			"}";
	}
}
