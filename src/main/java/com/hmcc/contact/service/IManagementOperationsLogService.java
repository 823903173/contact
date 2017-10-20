package com.hmcc.contact.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.hmcc.contact.entity.ManagementOperationsLog;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 管理操作日志 服务类
 * </p>
 *
 * @author chenhao
 * @since 2017-10-09
 */
public interface IManagementOperationsLogService extends IService<ManagementOperationsLog> {

    List<ManagementOperationsLog> queryByAdminId(int adminId);
}
