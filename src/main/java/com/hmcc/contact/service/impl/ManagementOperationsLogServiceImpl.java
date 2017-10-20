package com.hmcc.contact.service.impl;

import com.hmcc.contact.entity.ManagementOperationsLog;
import com.hmcc.contact.mapper.ManagementOperationsLogMapper;
import com.hmcc.contact.service.IManagementOperationsLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理操作日志 服务实现类
 * </p>
 *
 * @author chenhao
 * @since 2017-10-09
 */
@Service
public class ManagementOperationsLogServiceImpl extends ServiceImpl<ManagementOperationsLogMapper, ManagementOperationsLog> implements IManagementOperationsLogService {

    public List<ManagementOperationsLog> queryByAdminId(int adminId) {
        return baseMapper.queryByAdminId(adminId);
    }
}
