package com.dizikou.system.service;

/**
 * @author Just be alive
 * @version 1.0
 * @date 2021-12-11 - 13:21
 */
public interface IAuthenticationService {

    /**
     * pwdEncode
     *
     * @param password password
     * @return String
     */
    String pwdEncode(String password);

    /**
     * pwdDecode
     *
     * @param endodePwd endodePwd
     * @return String
     */
    String pwdDecode(String endodePwd);
}
