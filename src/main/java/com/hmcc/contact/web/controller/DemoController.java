package com.hmcc.contact.web.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hmcc.contact.entity.Demo;
import com.hmcc.contact.service.IDemoService;
import com.hmcc.contact.util.DoAjax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>

 * @author Yanghu
 * @since 2017-09-22
 */
@RestController
@RequestMapping("/demo")
public class DemoController extends AbstractController{
    @Autowired
    private IDemoService iDemoService;

    @GetMapping("lista")
    public List<Demo> list() {
        EntityWrapper<Demo> demoEntityWrapper = new EntityWrapper<>();
        return iDemoService.selectList(demoEntityWrapper);
    }

//    url:/demo/add.do?phoneNumber = xxx & remark = xxx
//    @PostMapping("add")
    @RequestMapping("add")
    public void add(HttpServletResponse response, HttpServletRequest request, long phoneNumber, String remark) {
        JSONObject json = new JSONObject();
        Demo demoEntityWrapper = new Demo();
        String phone =phoneNumber+"";
        demoEntityWrapper.setPhone(phone);
        demoEntityWrapper.setRemark(remark);
        demoEntityWrapper.setId("6");
//        demoEntityWrapper.setAge(12312);
//        demoEntityWrapper.setName("张三");
        demoEntityWrapper.setTestDate(new Date());
//        demoEntityWrapper.setState(1);
        boolean res = iDemoService.insert(demoEntityWrapper);
        json.put("flag",res);
        DoAjax.doAjax(response, json, null);
//        return iDemoService.insert(demoEntityWrapper);
    }

}
