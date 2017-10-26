package org.cw.midc.exception.handler;

import java.lang.reflect.UndeclaredThrowableException;

import org.cw.midc.Response;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice()
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response exceptionHandler(Exception e) {
        Response resp = new Response();
        resp.setCode(1);
        if(e instanceof UndeclaredThrowableException)
        {
        	e = (Exception)((UndeclaredThrowableException) e).getUndeclaredThrowable();
        }
        String errorMsg = e.getMessage();
        if(errorMsg.indexOf(":")>-1){
            errorMsg = errorMsg.split(":")[1];
        }
        resp.setMsg(errorMsg);
        return resp;
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }
}
