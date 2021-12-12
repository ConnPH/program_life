package com.dizikou.system.controller;

import com.dizikou.system.base.RestResponse;
import com.dizikou.system.enums.RoleEnum;
import com.dizikou.system.enums.UserStatusEnum;
import com.dizikou.system.model.entity.User;
import com.dizikou.system.model.entity.UserEventLog;
import com.dizikou.system.model.vo.RegisterVo;
import com.dizikou.system.service.IAuthenticationService;
import com.dizikou.system.service.IUserEventLogService;
import com.dizikou.system.service.IUserService;
import com.dizikou.system.util.DateUilts;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @author Just be alive
 * @version 1.0
 * @date 2021-12-11 - 16:58
 */
@RestController
public class RegisterController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserEventLogService userEventLogService;

    @Autowired
    private IAuthenticationService authenticationService;


    @PostMapping("/register/user")
    public RestResponse registerUser(@RequestBody RegisterVo registerVo){
        String userName = registerVo.getUserName();
        User existUser = userService.selectUserByUserName(userName);
        if (null != existUser){
            return RestResponse.fail(200001,"用户名已存在");
        }


        User user = new User();
        BeanUtils.copyProperties(registerVo, user);
        String pwdEncode = authenticationService.pwdEncode(registerVo.getPassWord());
        String id = UUID.randomUUID().toString().replace("-","").substring(1,10);
        user.setId("A"+ id);
        user.setPassWord(pwdEncode);
        user.setUserName(registerVo.getUserName());
        user.setDeleted("0");
        user.setRole(RoleEnum.STUDENT.getCode());
        user.setStatus(UserStatusEnum.Enable.getCode());
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        user.setRealName("学生1");
        userService.save(user);

        UserEventLog userEventLog = new UserEventLog();
        userEventLog.setUserId(user.getId());
        String[] ymd = DateUilts.getYMD();
        userEventLog.setLoginDate(ymd[0]);
        userEventLog.setLoginTime(ymd[1]);
        userEventLog.setUserName(user.getUserName());
        userEventLog.setContent("注册成功");
        userEventLogService.save(userEventLog);
        return RestResponse.ok();

    }

    public static void main(String[] args) {

    }
}
