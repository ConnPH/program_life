package com.dizikou.system.controller;

import com.dizikou.system.base.RestResponse;
import com.dizikou.system.enums.RoleEnum;
import com.dizikou.system.enums.UserStatusEnum;
import com.dizikou.system.model.entity.User;
import com.dizikou.system.model.entity.UserEventLog;
import com.dizikou.system.model.vo.RegisterVo;
import com.dizikou.system.service.IRegisterService;
import com.dizikou.system.util.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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


    private final IRegisterService registerService;

    @Autowired
    public RegisterController(IRegisterService registerService) {
        this.registerService = registerService;
    }


    @PostMapping("/register/user")
    public RestResponse registerUser(@RequestBody RegisterVo registerVo){
        registerService.registerUser(registerVo);
        return RestResponse.ok();
    }
}
