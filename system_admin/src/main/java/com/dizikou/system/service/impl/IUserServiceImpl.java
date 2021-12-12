package com.dizikou.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dizikou.system.mapper.UserMapper;
import com.dizikou.system.model.entity.User;
import com.dizikou.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Just be alive
 * @version 1.0
 * @date 2021-12-11 - 17:05
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByUserName(String userName) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("user_name",userName));
    }
}
