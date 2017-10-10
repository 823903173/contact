package com.hmcc.contact.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hmcc.contact.entity.ManagementOperationsLog;
import com.hmcc.contact.service.IManagementOperationsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 管理操作日志 前端控制器
 * </p>
 *
 * @author chenhao
 * @since 2017-10-09
 */
@RestController
@RequestMapping("/platform")
public class ManagementOperationsLogController extends AbstractController {
	@Autowired
    private IManagementOperationsLogService iManagementOperationsLogService;

    /*
      测试，并且 没有成功
      url:getOnesOfDepart.do?depart_id = xxx
     */
    @GetMapping("lista")
	public List<ManagementOperationsLog> list(){
        EntityWrapper<ManagementOperationsLog> managementOperationsLogEntityWrapper = new EntityWrapper<>();
        return iManagementOperationsLogService.selectList(managementOperationsLogEntityWrapper);
    }

    /*
      查询，根据管理员ID查询其操作
      url:queryByAdminId.do?admin_id = xxx
     */
    @GetMapping("queryByAdminId")
    public List<ManagementOperationsLog> queryByAdminId(int admin_id){
        List<ManagementOperationsLog> managementOperationsLogEntityWrapper = iManagementOperationsLogService.queryByAdminId(admin_id);
        return managementOperationsLogEntityWrapper;
    }

}
