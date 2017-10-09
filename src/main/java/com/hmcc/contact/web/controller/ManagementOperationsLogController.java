package com.hmcc.contact.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hmcc.contact.entity.ManagementOperationsLog;
import com.hmcc.contact.service.IManagementOperationsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 管理操作日志 前端控制器
 * </p>
 *
 * @author chenhao
 * @since 2017-10-09
 */
@Controller
@RequestMapping("/managementOperationsLog")
public class ManagementOperationsLogController extends AbstractController {
	@Autowired
    private IManagementOperationsLogService iManagementOperationsLogService;

    @GetMapping("lista")
	public List<ManagementOperationsLog> list(){
        EntityWrapper<ManagementOperationsLog> managementOperationsLogEntityWrapper = new EntityWrapper<>();
        return iManagementOperationsLogService.selectList(managementOperationsLogEntityWrapper);
    }
}
