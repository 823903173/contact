package com.hmcc.contact.util;

/**
 * Created by a8239 on 2017/10/13.
 */
public class randomMessageNumber {

//    生成6位随机整数
    public static int getIntRandomNumber(){
        int num = (int) ((Math.random())*1000000);
        return num;
    }

public static void main(String[] args){
        int a = getIntRandomNumber();
        System.out.println(a);
}
}
