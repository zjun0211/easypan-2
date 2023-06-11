package com.easypan.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.easypan.annotation.GlobalIterceptor;
import com.easypan.annotation.VerifyParam;
import com.easypan.entity.constants.Constants;
import com.easypan.entity.dto.CreateImageCode;
import com.easypan.entity.pojo.EmailCode;
import com.easypan.entity.pojo.UserInfo;
import com.easypan.entity.example.UserInfoExample;
import com.easypan.enums.ResponseCodeEnum;
import com.easypan.enums.VerifyRegexEnum;
import com.easypan.exception.BusinessException;
import com.easypan.service.EmailCodeService;
import com.easypan.service.UserInfoService;
import com.easypan.entity.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author 王先森
 * @create 2023年-06月-11日 上午 09:27
 * @Description UserInfoController对应数据库表db_user_info的Controller类
 * @Version V1.0
 */

@RestController
public class UserInfoController extends BaseController {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private EmailCodeService emailCodeService;

    //验证码获取接口
    @RequestMapping("/checkCode")
    public void checkCode(HttpServletResponse response, HttpSession session, Integer type) {
        CreateImageCode vCode = new CreateImageCode(130, 38, 5, 10);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        String code = vCode.getCode();
        if (type == null || type == 0) {
            session.setAttribute(Constants.CHECK_CODE_KEY, code);
        } else {
            session.setAttribute(Constants.CHECK_CODE_KEY_EMAIL, code);
        }
        try {
            vCode.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //邮件发送接口
    @RequestMapping("/sendEmailCode")
    @GlobalIterceptor(verifyParam = true)
    public ResponseVO sendEmailCode(@VerifyParam(required = true, regex = VerifyRegexEnum.EMAIL, max = 150) String email,
                                    @VerifyParam(required = true) String checkCode,
                                    @VerifyParam(required = true) Integer type, HttpSession session) {
        try {
            if (checkCode == null) {
                return getSuccessResponseVO("请先获取验证码");
            }
            if (!checkCode.equalsIgnoreCase((String) session.getAttribute(Constants.CHECK_CODE_KEY_EMAIL))) {
                throw new BusinessException(ResponseCodeEnum.CODE_905);
            }
            emailCodeService.sendEmailCode(email, type);

            return getSuccessResponseVO("发送成功");
        } finally {
            session.removeAttribute(Constants.CHECK_CODE_KEY_EMAIL);
        }
    }

    //注册接口
    @RequestMapping("/registry")
    @GlobalIterceptor(verifyParam = true)
    public ResponseVO registry(HttpSession session,
                               @VerifyParam(required = true, regex = VerifyRegexEnum.EMAIL, max = 150) String email,
                               @VerifyParam(required = true) String nickName,
                               @VerifyParam(required = true, regex = VerifyRegexEnum.PASSWORD, min = 8, max = 18) String password,
                               @VerifyParam(required = true) String checkCode,
                               @VerifyParam(required = true) String emailCode) {
        try {
            if (checkCode == null) {
                return getSuccessResponseVO("请先获取验证码");
            }
            if (!checkCode.equalsIgnoreCase((String) session.getAttribute(Constants.CHECK_CODE_KEY))) {
                throw new BusinessException(ResponseCodeEnum.CODE_905);
            }
            userInfoService.registry(email, nickName, password, emailCode);
            return getSuccessResponseVO("发送成功");
        } finally {
            session.removeAttribute(Constants.CHECK_CODE_KEY_EMAIL);
        }
    }
}

