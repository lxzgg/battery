package com.web.battery.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理
 */
@RestControllerAdvice
public class ExceptionHandle {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ErrorException.class)
    public Map errorException(ErrorException e) {
        log.error(e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("message", e.getMessage());
        return map;
    }

    /**
     * 权限不足
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public Map ForbiddenException(AccessDeniedException e) {
        log.error(e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpServletResponse.SC_FORBIDDEN);
        map.put("message", e.getMessage());
        return map;
    }

    @ResponseStatus()
    @ExceptionHandler()
    public Map exception(Exception e) {
        log.error(e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        map.put("message", e.getMessage());
        return map;
    }

}
