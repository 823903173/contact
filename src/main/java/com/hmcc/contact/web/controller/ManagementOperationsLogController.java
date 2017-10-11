package com.hmcc.contact.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hmcc.contact.entity.ManagementOperationsLog;
import com.hmcc.contact.service.IManagementOperationsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
    private int admin_id;
    private String operations_log;
    private Integer operations_result;
    private String operations_ip;

    /*
      测试，
      忽略这个 没什么用
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

    /*
      插入一条日志
      包涵参数如下
      url:insertOneLog.do?admin_id = xxx & create_time=xxx & operations_log=xxx & operations_result=xxx & operations_ip=xxx
      ######################################
      正在考虑是否使参数标准化。例如使用json
     */
    @GetMapping("insertOneLog")
    public void insertOneLog(int admin_id, Date create_time, String operations_log , Integer operations_result, String operations_ip){
//        创建一个对象
        ManagementOperationsLog managementOperationsLog = new ManagementOperationsLog();
//        把所有参数信息都放入其中
        managementOperationsLog.setAdminId(admin_id);
        managementOperationsLog.setCreateTime(create_time);
        managementOperationsLog.setOperationsLog(operations_log);
        managementOperationsLog.setOperationsResult(operations_result);
        managementOperationsLog.setOperationsIp(operations_ip);
        iManagementOperationsLogService.insert(managementOperationsLog);
    }

}
