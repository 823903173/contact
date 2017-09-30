package com.hmcc.contact.web.controller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by a8239 on 2017/9/29.
 */
@RequestMapping("/collectnewlog")
@Controller
public class CollectNewLogController extends AbstractController {
    private final Logger logger = Logger.getLogger(CollectNewLogController.class);

    @RequestMapping("addnewlog")
    public void addNewLog(ArrayList<String> list){



    }
}
