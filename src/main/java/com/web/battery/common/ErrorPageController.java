package com.web.battery.common;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 错误页面配置
 */
@Controller
public class ErrorPageController implements ErrorController {

    @GetMapping("error")
    public String error(HttpServletRequest request) {
        Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Object message = request.getAttribute("javax.servlet.error.message");
        if (message == null) message = "未知错误";

        if (code == 500) throw new RuntimeException("服务器内部错误");
        if (code == 403) throw new AccessDeniedException("不允许访问");
        if (code != 404) throw new ErrorException(code, message.toString());

        return "forward:/404";
    }

    @Override
    @GetMapping("404")
    public String getErrorPath() {
        return "common/404";
    }

}
