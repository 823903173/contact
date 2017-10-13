package com.hmcc.contact.util;

import java.util.Date;
import java.util.Calendar;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * Created by a8239 on 2017/10/13.
 */
public class getNowTime {

    public static String getNowTimeByJava(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
        String hehe = dateFormat.format( now );
        return hehe;
    }

    public static void main(String[] args){


    }

}
