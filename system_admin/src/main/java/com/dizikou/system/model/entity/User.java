package com.dizikou.system.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("tb_user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -7797183521247423117L;

    private String id;


    /**
     * 用户名
     */
    private String userName;

    private String passWord;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 1.学生  3.管理员
     */
    private String role;

    /**
     * 1.启用 2禁用
     */
    private String status;


    private Date gmtCreate;

    private Date gmtModified;


    /**
     * 是否删除
     */
    private String deleted;
}
