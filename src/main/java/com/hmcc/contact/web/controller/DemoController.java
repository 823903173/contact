package com.hmcc.contact.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hmcc.contact.entity.Demo;
import com.hmcc.contact.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Yanghu
 * @since 2017-09-22
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private IDemoService iDemoService;

    @GetMapping
    public List<Demo> list() {
        EntityWrapper<Demo> demoEntityWrapper = new EntityWrapper<>();
        return iDemoService.selectList(demoEntityWrapper);
    }
    @PostMapping("add")
    public boolean add() {
        Demo demoEntityWrapper = new Demo();
        demoEntityWrapper.setAge(12312);
        demoEntityWrapper.setName("张三");
        demoEntityWrapper.setTestDate(new Date());
        demoEntityWrapper.setState(1);
        return iDemoService.insert(demoEntityWrapper);
    }
}
