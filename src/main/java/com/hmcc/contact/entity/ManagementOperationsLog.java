package com.hmcc.contact.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;

/**
 * <p>
 * 管理操作日志
 * </p>
 *
 * @author chenhao
 * @since 2017-10-09
 */
@TableName("contact_management_operations_log")
public class ManagementOperationsLog extends Model<ManagementOperationsLog> {

    private static final long serialVersionUID = 1L;

	@TableId(value="system_id", type= IdType.AUTO)
	private Integer systemId;
	@TableField("admin_id")
	private Integer adminId;
	@TableField("create_time")
	private String createTime;
	@TableField("operations_log")
	private String operationsLog;
	@TableField("operations_result")
	private Integer operationsResult;
	@TableField("operations_ip")
	private String operationsIp;
	@TableField("extned_id")
	private String extnedId;
	@TableField("extend_id")
	private String extendId;


	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOperationsLog() {
		return operationsLog;
	}

	public void setOperationsLog(String operationsLog) {
		this.operationsLog = operationsLog;
	}

	public Integer getOperationsResult() {
		return operationsResult;
	}

	public void setOperationsResult(Integer operationsResult) {
		this.operationsResult = operationsResult;
	}

	public String getOperationsIp() {
		return operationsIp;
	}

	public void setOperationsIp(String operationsIp) {
		this.operationsIp = operationsIp;
	}

	public String getExtnedId() {
		return extnedId;
	}

	public void setExtnedId(String extnedId) {
		this.extnedId = extnedId;
	}

	public String getExtendId() {
		return extendId;
	}

	public void setExtendId(String extendId) {
		this.extendId = extendId;
	}

	@Override
	protected Serializable pkVal() {
		return this.systemId;
	}

	@Override
	public String toString() {
		return "ManagementOperationsLog{" +
			", systemId=" + systemId +
			", adminId=" + adminId +
			", createTime=" + createTime +
			", operationsLog=" + operationsLog +
			", operationsResult=" + operationsResult +
			", operationsIp=" + operationsIp +
			", extnedId=" + extnedId +
			", extendId=" + extendId +
			"}";
	}
}
