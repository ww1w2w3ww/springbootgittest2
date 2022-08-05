package com.example.workforspringboot.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.workforspringboot.entity.Admin;
import com.example.workforspringboot.exception.MyException;
import com.example.workforspringboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Calendar;


public class JWTUtils {
    private static final String TOKEN_SECRET = "token";
    @Autowired
    private AdminService adminService;

    public static String getToken(Admin admin) {
        Calendar instance = Calendar.getInstance();
        //默认令牌过期时间7天
        instance.add(Calendar.DATE, 7);

        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("account", admin.getAccount()).withClaim("password",admin.getPassword());

        return builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(TOKEN_SECRET));
    }

    /**
     * 验证token合法性 成功返回token
     */
    public static DecodedJWT verify(String token) throws MyException {
        if(StringUtils.isEmpty(token)){
            throw new MyException("token不能为空");
        }


        String password = "token";
        JWTVerifier build = JWT.require(Algorithm.HMAC256(password)).build();
        return build.verify(token);//
        // build.verify(token);

    }

   /* public static void main(String[] args) {
        DecodedJWT verify = verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTcxMDg1MDAsInVzZXJuYW1lIjoiYWRtaW4ifQ.geBEtpluViRUg66_P7ZisN3I_d4e32Wms8mFoBYM5f0");
        System.out.println(verify.getClaim("password").asString());
    }*/
}
