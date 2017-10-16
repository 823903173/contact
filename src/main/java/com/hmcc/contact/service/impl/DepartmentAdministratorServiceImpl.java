package com.hmcc.contact.service.impl;

import com.hmcc.contact.entity.DepartmentAdministrator;
import com.hmcc.contact.mapper.DepartmentAdministratorMapper;
import com.hmcc.contact.service.IDepartmentAdministratorService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门管理员表 服务实现类
 * </p>
 *
 * @author chenhao
 * @since 2017-10-16
 */
@Service
public class DepartmentAdministratorServiceImpl extends ServiceImpl<DepartmentAdministratorMapper, DepartmentAdministrator> implements IDepartmentAdministratorService {
    @Override
    public boolean CheckDepartmentPhoneNumber(long phoneNumber) {
        return baseMapper.CheckDepartmentPhoneNumber(phoneNumber);
    }
}
