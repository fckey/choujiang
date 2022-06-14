package com.choujiang.exception;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName BusinessException
 * @Description 异常
 * @createTime 2022/06/14 9:41
 **/
public class BusinessException extends RuntimeException{
    private BusinessExceptionCode code;

    public BusinessException (BusinessExceptionCode code) {
        super(code.getDesc());
        this.code = code;
    }

    public BusinessExceptionCode getCode() {
        return code;
    }

    public void setCode(BusinessExceptionCode code) {
        this.code = code;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}