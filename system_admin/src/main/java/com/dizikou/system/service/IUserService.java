package com.dizikou.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dizikou.system.model.entity.User;

/**
 * @author Just be alive
 * @version 1.0
 * @date 2021-12-11 - 17:04
 */
public interface IUserService extends IService<User> {

    User selectUserByUserName(String userName);

}
