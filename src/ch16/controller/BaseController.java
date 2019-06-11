package ch16.controller;

import ch16.exception.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class BaseController {
    /** 基于@ExceptionHandler异常处理*/
    @ExceptionHandler
    public String exception(HttpServletRequest request, Exception ex)  {
        request.setAttribute("ex", ex);
        // 根据不同错误转向不同页面，即异常与View的对应关系
        if(ex instanceof SQLException) {
            return "sql-error";
        }else if(ex instanceof MyException) {
            return "my-error";
        } else {
            return "error";
        }
    }
}
