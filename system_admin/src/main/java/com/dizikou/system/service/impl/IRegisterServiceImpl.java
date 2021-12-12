package com.dizikou.system.service.impl;

import com.dizikou.system.base.RestResponse;
import com.dizikou.system.enums.RoleEnum;
import com.dizikou.system.enums.UserStatusEnum;
import com.dizikou.system.mapper.UserEventLogMapper;
import com.dizikou.system.mapper.UserMapper;
import com.dizikou.system.model.entity.User;
import com.dizikou.system.model.entity.UserEventLog;
import com.dizikou.system.model.vo.RegisterVo;
import com.dizikou.system.service.IAuthenticationService;
import com.dizikou.system.service.IRegisterService;
import com.dizikou.system.service.IUserService;
import com.dizikou.system.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author Just be alive
 * @version 1.0
 * @date 2021-12-12 - 15:18
 */
@Transactional
@Service
@Slf4j
public class IRegisterServiceImpl implements IRegisterService {
    private final UserMapper userMapper;

    private final UserEventLogMapper userEventLogMapper;

    private final IUserService userService;

    private final IAuthenticationService authenticationService;

    @Autowired
    public IRegisterServiceImpl(UserMapper userMapper, UserEventLogMapper userEventLogMapper, IUserService userService, IAuthenticationService authenticationService) {
        this.userMapper = userMapper;
        this.userEventLogMapper = userEventLogMapper;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }


    @Override
    public void registerUser(RegisterVo registerVo) {
        User existUser = userService.selectUserByUserName(registerVo.getUserName());

        if (null != existUser) {
            return;
        }

        User user = new User();
        BeanUtils.copyProperties(registerVo, user);
        String pwdEncode = authenticationService.pwdEncode(registerVo.getPassWord());
        String id = UUID.randomUUID().toString().replace("-", "").substring(1, 10);
        user.setId("A" + id);
        user.setPassWord(pwdEncode);
        user.setUserName(registerVo.getUserName());
        user.setDeleted("0");
        user.setRole(RoleEnum.STUDENT.getCode());
        user.setStatus(UserStatusEnum.Enable.getCode());
        userMapper.insert(user);


        UserEventLog userEventLog = new UserEventLog();
        userEventLog.setUserId(user.getId());
        String[] ymd = DateUtils.getYMD();
        userEventLog.setLoginDate(ymd[0]);
        userEventLog.setLoginTime(ymd[1]);
        userEventLog.setUserName(user.getUserName());
        userEventLog.setContent(user.getUserName() + " 注册成功 !");
        userEventLogMapper.insert(userEventLog);
    }
}
