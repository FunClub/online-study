package com.taomei.web.share.aspect;

import com.taomei.web.share.data.ResultView;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResultViewAspect {
    @Pointcut(value = "bean(*Controller)")
    public void includePointCut(){}

    @Pointcut(value = "execution(* com.taomei.web.share.contorller.ShareController.createVerificationCodeImg(..))")
    public void excludePointCut(){}

    @Around("includePointCut()&&!excludePointCut()")
    public Object handReturnValue(ProceedingJoinPoint pjp) throws Throwable {
        Object value=pjp.proceed();
        ResultView resultView=new ResultView();
        resultView.setCode(200);
        resultView.setMessage("请求处理成功");
        resultView.setData(value);
        return new ResponseEntity<ResultView>(resultView,HttpStatus.OK);
    }
}
