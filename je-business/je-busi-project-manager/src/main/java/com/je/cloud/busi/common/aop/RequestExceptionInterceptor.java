package com.je.cloud.busi.common.aop;


import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
@EnableAspectJAutoProxy
public class RequestExceptionInterceptor {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static Gson gson;

    // @Pointcut("@annotation(ExtendPoint)")     //ExtendPoint为自定义的注解
    @Pointcut("execution(* com..*.*Controller.*(..))")   //表示controller目录下的所有类名包含Controller的类中所有的公有方法
    public void requestInterceptorService() {
    }

    @Around("requestInterceptorService()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (gson == null) {
            gson = new Gson();
        }
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Object result;
        try {
            result = joinPoint.proceed();
            //log.info("=====request end=====");
            //log.info("result : {}", gson.toJson(result));
        } catch (Exception e) {
            System.out.println("=======================RequestInterceptor log start=====================================================");
            System.out.println("=======================RequestInterceptor log start with exception====================================");
            Object[] args = joinPoint.getArgs();
            List<Object> logArgs = Arrays.asList(args).stream()
                    .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                    .collect(Collectors.toList());
            System.out.println("======Exception info=====");
            System.out.println(e.getLocalizedMessage());
            System.out.println("======request info=====");
            System.out.println("url :" + request.getRequestURL());
            System.out.println("uri :" + request.getRequestURI());
            System.out.println("method : " + request.getMethod());
            System.out.println("param :" + gson.toJson(logArgs));
//            StackTraceElement[] stackTraceElements = e.getStackTrace();
//            byte[] bytes = new byte[]{};
//            for (StackTraceElement element : stackTraceElements) {
//                byte[] byteArray = element.toString().getBytes();
//                bytes = Bytes.concat(bytes, byteArray);
//            }
//            bytes = Bytes.concat(("*exception*" + e.getMessage() + "*exception*").getBytes(), bytes);
            System.out.println("=======================RequestInterceptor log end with exception====================================");
            System.out.println("=======================RequestInterceptor log end=====================================================");
            e.printStackTrace();
            throw e;
        }
        return result;
    }
}
