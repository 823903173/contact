package com.hmcc.contact.mapper;

import com.hmcc.contact.entity.ManagementOperationsLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
  * 管理操作日志 Mapper 接口
 * </p>
 *
 * @author chenhao
 * @since 2017-10-09
 */
public interface ManagementOperationsLogMapper extends BaseMapper<ManagementOperationsLog> {

    @Select("queryByAdminId")
    List<ManagementOperationsLog> queryByAdminId(int adminId);
}