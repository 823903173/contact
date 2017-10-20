package com.hmcc.contact.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yanghu
 * @since 2017-09-22
 */
@TableName("tv_demo")
public class Demo extends Model<Demo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private String id;
    /**
     * 名称
     */
	private String name;
    /**
     * 年龄
     */
	private Integer age;
    /**
     * 测试下划线字段命名类型
     */
	@TableField("test_type")
	private Integer testType;
    /**
     * 日期
     */
	@TableField("test_date")
	private Date testDate;
    /**
     * 状态(1-正常 0-禁用 -99 删除)
     */
	private Integer state;
    /**
     * 手机号码
     */
	private String phone;
    /**
     * 备注
     */
	private String remark;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getTestType() {
		return testType;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Demo{" +
			", id=" + id +
			", name=" + name +
			", age=" + age +
			", testType=" + testType +
			", testDate=" + testDate +
			", state=" + state +
			", phone=" + phone +
			", remark=" + remark +
			"}";
	}
}
