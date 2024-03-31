package com.KuangYafei.week5.demo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理 GET 请求的代码
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 连接数据库验证用户名和密码
        try {
            // 加载数据库驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // 建立数据库连接
            String url = "jdbc:sqlserver://localhost:1433;databaseName=userdb;";
            String dbUsername = "sa";
            String dbPassword = "123456";
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            // 执行查询
            String query = "SELECT * FROM usertable WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // 用户名和密码验证成功
                String welcomeMessage = "Welcome " + username;
                response.getWriter().println("<h1>Login Success !!!</h1>");
                response.getWriter().println("<h1>" + welcomeMessage + "</h1>");
            } else {
                // 用户名和密码验证失败
                response.getWriter().println("<h1>Login User Not Found</h1>");
            }

            // 关闭资源
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // 处理异常情况
        }
    }

}
