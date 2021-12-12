package com.dizikou.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dizikou.system.mapper.UserEventLogMapper;
import com.dizikou.system.model.entity.UserEventLog;
import com.dizikou.system.service.IUserEventLogService;
import org.springframework.stereotype.Service;

/**
 * @author Just be alive
 * @version 1.0
 * @date 2021-12-11 - 12:59
 */
@Service
public class IUserEventLogServiceImpl extends ServiceImpl<UserEventLogMapper, UserEventLog> implements IUserEventLogService {

}
