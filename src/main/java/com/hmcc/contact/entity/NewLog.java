package com.hmcc.contact.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * Created by a8239 on 2017/9/29.
 */
@TableName("management_operation_log")
public class NewLog implements Serializable {

    /** 用户ID */
    private Long id;

    /** 用户名 */
    private String name;

    /** 用户年龄 */
    private Integer age;

    @TableField(exist = false)
    private String state;

}
