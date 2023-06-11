package com.easypan.controller;

import com.easypan.enums.ResponseCodeEnum;
import com.easypan.entity.vo.ResponseVO;
/**
 * @author 王哲
 * @ClassName BaseController
 * @Description 创建基础类 代码生成器生成
 * @Version V1.0
 */

public class BaseController {
    protected static final String STATUC_SUCCES = "succes";
    protected static final String STATUC_ERROR = "error";

    protected <T> ResponseVO getSuccessResponseVO(T t) {
        ResponseVO<T> responseVO = new ResponseVO<>();
        responseVO.setStatus(STATUC_SUCCES);
        responseVO.setCode(ResponseCodeEnum.CODE_200.getCode());
        responseVO.setInfo(ResponseCodeEnum.CODE_200.getMsg());
        responseVO.setData(t);
        return responseVO;
    }
}
