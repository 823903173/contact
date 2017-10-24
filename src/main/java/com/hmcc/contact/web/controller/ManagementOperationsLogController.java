package com.hmcc.contact.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hmcc.contact.entity.ManagementOperationsLog;
import com.hmcc.contact.service.IManagementOperationsLogService;
import com.hmcc.contact.util.*;
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
 * *
 *----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━by:coder-chenhao
 *
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
      url:/platform/getOnesOfDepart.do?depart_id = xxx
     */
    @GetMapping("lista")
	public List<ManagementOperationsLog> list(){
        EntityWrapper<ManagementOperationsLog> managementOperationsLogEntityWrapper = new EntityWrapper<>();
        return iManagementOperationsLogService.selectList(managementOperationsLogEntityWrapper);
    }

    /*
      查询，
      根据管理员ID查询其操作
      （估计前台并没有页面展示，所以并没用。。。。。）
      url:/platform/queryByAdminId.do?admin_id = xxx
     */
    @RequestMapping("queryByAdminId")
    public List<ManagementOperationsLog> queryByAdminId(int admin_id){
        List<ManagementOperationsLog> managementOperationsLogEntityWrapper = iManagementOperationsLogService.queryByAdminId(admin_id);
        return managementOperationsLogEntityWrapper;
    }

    /*
      【前端没用，不用看】
      插入一条日志
      包涵参数如下
      url:/platform/insertOneLog.do?admin_id = xxx & create_time=xxx & operations_log=xxx & operations_result=xxx & operations_ip=xxx
      ######################################
      正在考虑是否使参数标准化。例如使用json
     */
    @RequestMapping("insertOneLog")
    public void insertOneLog(Long admin_id, String operations_log , Integer operations_result, String operations_ip){
//        创建一个对象
        ManagementOperationsLog managementOperationsLog = new ManagementOperationsLog();
//        把所有参数信息都放入其中
        managementOperationsLog.setAdminId(admin_id);
        //调用工具类 湖区当前时间
        getNowTime nowTime = new getNowTime();
        String create_time = nowTime.getNowTimeByJava();
        //把参数都放进去
        managementOperationsLog.setCreateTime(create_time);
        managementOperationsLog.setOperationsLog(operations_log);
        managementOperationsLog.setOperationsResult(operations_result);
        managementOperationsLog.setOperationsIp(operations_ip);
        iManagementOperationsLogService.insert(managementOperationsLog);
    }

}
