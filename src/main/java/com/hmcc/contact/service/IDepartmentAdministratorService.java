package com.hmcc.contact.service;

import com.hmcc.contact.entity.DepartmentAdministrator;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 部门管理员表 服务类
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 */
public interface IDepartmentAdministratorService extends IService<DepartmentAdministrator> {
    boolean CheckDepartmentPhoneNumber(long phoneNumber);
}
