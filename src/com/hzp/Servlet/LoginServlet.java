package com.hzp.Servlet;

import com.alibaba.fastjson.JSON;
import com.hzp.Dao.UserDao;
import com.hzp.Dao.UserDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ASUS
 * @projectName JSON_class
 * @description:
 * @date 2021-12-10 11:17
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        UserDao userDao=new UserDaoImp();

        String s=JSON.toJSONString( userDao.findByName(username));
        System.out.println(s);
        response.getWriter().println(s);
    }
}
