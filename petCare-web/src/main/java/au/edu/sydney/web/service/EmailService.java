package au.edu.sydney.web.service;

import au.edu.sydney.base.Result;

/**
 * @author Chris
 * @date 2021-09-21 09:31
 * @description
 */
public interface EmailService {

    Result sendEmailVerificationCode(String email);


    Result verifyCode(String email,String code);
}
