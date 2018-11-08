package com.web.battery.common;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回值处理
 */
@ControllerAdvice
public class ResponseBodyHandle implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // 异常类不处理返回值
        return !returnType.getContainingClass().isNestmateOf(ExceptionHandle.class);
    }

    @Override
    public Map beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        HttpServletResponse resp = ((ServletServerHttpResponse) response).getServletResponse();
        HttpServletRequest req = ((ServletServerHttpRequest) request).getServletRequest();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("message", "success");
        map.put("data", body);

        resp.setHeader("X-Response-Time", String.valueOf(System.currentTimeMillis() - (long) req.getAttribute("X-Response-Time") + "ms"));
        return map;
    }

}
