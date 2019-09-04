package com.imooc.sell.VO;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @Description Http请求返回的最外层对象
 * @Author GOODRR
 * @Date 2019/9/4 15:36
 * @Version 1.0
 **/
@Data
public class ResultVO<T>
{
    /** 错误码*/
    private Integer code;
    /** 提示信息*/
    private String msg;
    /** 具体内容*/
    private T data;

}
