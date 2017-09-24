package com.taomei.web.share.aspect;


import com.taomei.web.share.data.ResultView;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerAspect {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultView handleException(Exception e){
        ResultView resultView=new ResultView();
        resultView.setCode(200);
        resultView.setMessage("请求处理成功");
        return resultView;
    }
}
