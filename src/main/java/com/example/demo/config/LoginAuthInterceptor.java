package com.example.demo.config;

import com.example.demo.result.BaseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author :LiXiangJie
 * @description : TODO
 * @date :2021/11/20 21:56
 */
public class LoginAuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //这里实际是从redis中获取到session信息
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userInfoId");
        if (userId == null) {
            authFailOutput(response, "登录信息不存在，请重新登录");
            return false;
        }
        return true;
    }

    /**
     * json输出
     *
     * @param response
     * @throws IOException
     */
    private void authFailOutput(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        out.write(objectMapper.writeValueAsString(BaseResult.error().message(msg)));
        out.flush();
    }
}
