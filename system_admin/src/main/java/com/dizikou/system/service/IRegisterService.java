package com.dizikou.system.service;

import com.dizikou.system.base.RestResponse;
import com.dizikou.system.model.vo.RegisterVo;

/**
 * @author Just be alive
 * @version 1.0
 * @date 2021-12-12 - 15:18
 */
public interface IRegisterService {
   void registerUser(RegisterVo registerVo);
}
