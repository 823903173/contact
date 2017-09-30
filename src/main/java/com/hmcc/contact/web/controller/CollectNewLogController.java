package com.hmcc.contact.web.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hmcc.contact.entity.Demo;
import com.hmcc.contact.entity.NewLog;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hmcc.contact.service.INewLogService;
import sun.security.util.BigInt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a8239 on 2017/9/29.
 */
@RequestMapping("/collectnewlog")
@Controller
public class CollectNewLogController extends AbstractController {
    private INewLogService iNewLogService;

    private final Logger logger = Logger.getLogger(CollectNewLogController.class);

    @GetMapping("list")
    public List<NewLog> list() {
        EntityWrapper<NewLog> newlogEntityWrapper = new EntityWrapper<>();
        return iNewLogService.selectList(newlogEntityWrapper);
    }

    @RequestMapping("addnewlog")
    public void addNewLog(ArrayList<NewLog> list){
//        EntityWrapper<NewLog> demoEntityWrapper = new EntityWrapper<>();
        NewLog newLogEntityWrapper = new NewLog();
        newLogEntityWrapper.setAdmin_id(2);
        newLogEntityWrapper.setOperations_log("asdasdasd");
//        return iNewLogService.insert(newLogEntityWrapper);
    }
}
