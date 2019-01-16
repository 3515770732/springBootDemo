package com.common.exception;

public interface BusincessExceptionCode {

    /** 系统异常 */
    public static final int EXP_XT = -1;
    /** 用户未登录 */
    public static final int EXP_NOLOGIN = 100;
    /** 用户没有权限 */
    public static final int EXP_NOAUTH = 101;
    /** 用户强制下线 */
    public static final int EXP_REPEATLOGIN = 102;
    /** 帐户已登录 */
    public static final int EXP_LOGINED_OTHER = 103;
    /** 请求重复提交 */
    public static final int EXP_TOKEN_DUPREQ = 20;
    /** 签名验证异常 */
    public static final int EXP_SIGN = 300;

    /** 参数异常 */
    public static final int PARAM_EXP_CODE = 10;
    /** 业务处理中 */
    public static final int BUSINESS_DOING = 30;
    /** 业务校验异常 */
    public static final int BUSINESS_VALIDATE_EXP = 40;
    /** 业务异常 */
    public static final int BUSINESS_EXP = 50;
    /** 查询对象不存在 */
    public static final int NON_EXISTENT = 60;
    /** 访问来源异常 */
    public static final int REFERER_EXP = 60;
}
