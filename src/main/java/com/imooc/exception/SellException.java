package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * @ClassName SellException
 * @Description TODO
 * @Author GOODRR
 * @Date 2019/9/5 15:48
 * @Version 1.0
 **/
public class SellException extends RuntimeException
{
    private Integer code;

    public SellException(ResultEnum resultEnum)
    {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
