package com.dizikou.system.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author Just be alive
 * @version 1.0
 * @date 2021-12-10 - 22:07
 */

@TableName("tb_user_event_log")
@Data
public class UserEventLog {

    private static final Logger logger = LoggerFactory.getLogger(UserEventLog.class);

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userId;

    private String userName;

    private String realName;

    private Date createTime;

    // date
    private String loginDate;

    // time
    private String loginTime;


    private String content;


}
