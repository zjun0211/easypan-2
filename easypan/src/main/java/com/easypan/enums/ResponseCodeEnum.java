package com.easypan.enums;

/**
 * @author 王哲
 * @ClassName ResponseCodeEnum
 * @Description 创建基础类 代码生成器生成
 * @Version V1.0
 */

public enum ResponseCodeEnum {
    CODE_200(200, "请求成功"),

    CODE_404(404, "请求地址不存在"),

    CODE_600(600, "请求参数错误"),
    CODE_601(601, "信息已经存在"),

    CODE_500(500, "服务器返回错误,请联系管理员"),

    CODE_901(901, "登录超时,请重新登录"),
    CODE_902(902, "分享链接不存在,或已失效"),
    CODE_903(903, "分享验证失效,请重新验证"),
    CODE_904(904, "网盘空间不足,请扩容"),

    //注册业务
    CODE_905(905, "验证码不正确,请核实后重新输入"),
    CODE_906(906, "该邮箱已被注册"),
    CODE_907(907, "该昵称已存在"),
    CODE_908(908, "邮箱和验证码不匹配"),
    CODE_909(909, "邮箱验证码已失效,请重新获取");

    private Integer code;

    private String msg;

    ResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
