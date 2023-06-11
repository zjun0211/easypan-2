package com.easypan.controller;

import com.easypan.enums.ResponseCodeEnum;
import com.easypan.entity.vo.ResponseVO;
import com.easypan.exception.BusinessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 王哲
 * @ClassName BusinessException
 * @Description 创建基础类 代码生成器生成
 * @Version V1.0
 */

@RestControllerAdvice
public class ExceptionHandlerController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(value = Exception.class)
    Object handleException(Exception e, HttpServletRequest request) {
        logger.error("请求错误,请求地址{},错误信息:", request.getRequestURL(), e);
        ResponseVO ajaxResponse = new ResponseVO();
        //404
        if (e instanceof NoHandlerFoundException) {
            ajaxResponse.setCode(ResponseCodeEnum.CODE_404.getCode());
            ajaxResponse.setInfo(ResponseCodeEnum.CODE_404.getMsg());
            ajaxResponse.setStatus(STATUC_ERROR);
        } else if (e instanceof BusinessException) {
            //业务错误
            BusinessException biz = (BusinessException) e;
            ajaxResponse.setCode(biz.getCode());
            ajaxResponse.setInfo(biz.getMessage());
            ajaxResponse.setStatus(STATUC_ERROR);
        } else if (e instanceof BindException) {
            //参数类型错误
            ajaxResponse.setCode(ResponseCodeEnum.CODE_600.getCode());
            ajaxResponse.setInfo(ResponseCodeEnum.CODE_600.getMsg());
            ajaxResponse.setStatus(STATUC_ERROR);
        } else if (e instanceof DuplicateKeyException) {
            //主键冲突
            ajaxResponse.setCode(ResponseCodeEnum.CODE_601.getCode());
            ajaxResponse.setInfo(ResponseCodeEnum.CODE_601.getMsg());
            ajaxResponse.setStatus(STATUC_ERROR);
        } else {
            ajaxResponse.setCode(ResponseCodeEnum.CODE_901.getCode());
            ajaxResponse.setInfo(ResponseCodeEnum.CODE_901.getMsg());
            ajaxResponse.setStatus(STATUC_ERROR);
        }
        return ajaxResponse;
    }
}
