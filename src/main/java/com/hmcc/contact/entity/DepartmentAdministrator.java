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
 * 部门管理员表
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 */
@TableName("department_administrator")
public class DepartmentAdministrator extends Model<DepartmentAdministrator> {

    private static final long serialVersionUID = 1L;

	@TableId(value="system_id", type= IdType.AUTO)
	private Integer systemId;
	@TableField("management_number")
	private Integer managementNumber;
	@TableField("organization_id")
	private String organizationId;
	@TableField("contact_number")
	private Long contactNumber;
	private Integer state;
	@TableField("create_time")
	private String createTime;
	@TableField("create_admin_id")
	private Integer createAdminId;
	@TableField("last_modify_time")
	private String lastModifyTime;
	@TableField("last_modify_admin_id")
	private Integer lastModifyAdminId;
	@TableField("extend_1")
	private String extend1;
	@TableField("extend_2")
	private String extend2;
	@TableField("extend_3")
	private String extend3;
	@TableField("extend_4")
	private String extend4;


	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateAdminId() {
		return createAdminId;
	}

	public void setCreateAdminId(Integer createAdminId) {
		this.createAdminId = createAdminId;
	}

	public String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getLastModifyAdminId() {
		return lastModifyAdminId;
	}

	public void setLastModifyAdminId(Integer lastModifyAdminId) {
		this.lastModifyAdminId = lastModifyAdminId;
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
	protected Serializable pkVal() {
		return this.systemId;
	}

	@Override
	public String toString() {
		return "DepartmentAdministrator{" +
			", systemId=" + systemId +
			", managementNumber=" + managementNumber +
			", organizationId=" + organizationId +
			", contactNumber=" + contactNumber +
			", state=" + state +
			", createTime=" + createTime +
			", createAdminId=" + createAdminId +
			", lastModifyTime=" + lastModifyTime +
			", lastModifyAdminId=" + lastModifyAdminId +
			", extend1=" + extend1 +
			", extend2=" + extend2 +
			", extend3=" + extend3 +
			", extend4=" + extend4 +
			"}";
	}
}
