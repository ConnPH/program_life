package com.dizikou.system.service.impl;

import com.dizikou.system.service.IAuthenticationService;
import com.dizikou.system.util.RsaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Just be alive
 * @version 1.0
 * @date 2021-12-11 - 13:21
 */
@Slf4j
@Service
public class IAuthenticationServiceImpl implements IAuthenticationService {


    private final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQClwwxhJKwStDnu7c0yCRkwTW2VKuLWwyVtFC6Zx9bYdF1qwqSP26CkDwaF6GHayIvv9b8BHlAaQH4SLIPzir062yzNukqspmthUw4gPJhbx1AQrWRoQJSv3/1Sk+tWyJRHXSiCZJZ3216LDhtx42LQ0HItDP8U9BLtsxA+5LEZzQIDAQAB";

    private final String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKXDDGEkrBK0Oe7tzTIJGTBNbZUq4tbDJW0ULpnH1th0XWrCpI/boKQPBoXoYdrIi+/1vwEeUBpAfhIsg/OKvTrbLM26Sqyma2FTDiA8mFvHUBCtZGhAlK/f/VKT61bIlEddKIJklnfbXosOG3HjYtDQci0M/xT0Eu2zED7ksRnNAgMBAAECgYEAlCuz5yn2volnt9HNuEo1v92WdN5vAnZSAB0oQsJFpBrwXjw7CXTTNZNQy2YcAot9uzO6Vu+Xvr+jce9ky9BasM7ehz0gnwJWAO79IqUnmu3RRq7HllDwp72qysXIypJZCF4HX5jAzUGlNzlTSUb1H4LtavKc6a//YqPfQ0jTLsECQQDZuGKGAYq6rBCX0+T8qlQpCPc41wsl4Gi9lLD21ks9PMx44JdhsUrqLWItZiGynDzq1LJ3M1hr3gbSsPQcI9HJAkEAwugDFCiRLOqOBRRGlYbzgGdmXbR4SrMNIpcFTFhU+MsEqaMueVPiNtRSIK6W8pS28ZN0aiZDTBAT84fOIENp5QJBAJaVgQ9OYbVa7N8WH3riE/ONz+/wTDWWUNtOzFbtQHzKYGH6dLmM9lOhsBXWXdg7V6bUFdt8F9wDZJS07yHHZIECQG4rHrJiS80Lt8L/NvaGFVVbHO2SePwgQShwHLqOo1kNyFDqv/YsiA1d7h4zEXeEv/PE2WS2xAtWezCIbualtFECQQDPUkYhs3vZoZgsltdeFnv/WoXaXNRIzunMTmksIlh8JP7C1xQHrwdCpUkffgSVphxGJGHkxooMpki7oTC1Mdjx";

    @Override
    public String pwdEncode(String password) {
        //return RsaUtil.rsaEncode(systemConfig.getPwdKey().getPublicKey(), password);
        return RsaUtil.rsaEncode(publicKey, password);
    }

    @Override
    public String pwdDecode(String encodePwd) {
        //return RsaUtil.rsaDecode(systemConfig.getPwdKey().getPrivateKey(), encodePwd);
        return RsaUtil.rsaDecode(privateKey, encodePwd);
    }



}
