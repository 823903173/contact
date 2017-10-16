package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.DepartmentAdministrator;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
  * 部门管理员表 Mapper 接口
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 */
public interface DepartmentAdministratorMapper extends BaseMapper<DepartmentAdministrator> {
    @Select("CheckDepartmentPhoneNumber")
    boolean CheckDepartmentPhoneNumber(long phoneNumber);
}