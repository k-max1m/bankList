package bankList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by k-max1m on 10.12.2019.
 */
public class AddUser extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        PrintWriter writer = httpServletResponse.getWriter();
        String name = httpServletRequest.getParameter("name");
        String sureName = httpServletRequest.getParameter("sureName");
        int userId = Integer.parseInt(httpServletRequest.getParameter("userId"));
        int account = Integer.parseInt(httpServletRequest.getParameter("account"));
        int accountId = Integer.parseInt(httpServletRequest.getParameter("accountId"));

        String sqlAddUser = "INSERT INTO `banklist`.`user`(`userid`,`name`,`sureName`) VALUES('" + userId + "','" + name + "','" + sureName + "');";
        String sqlAddAccount =  "INSERT INTO `banklist`.`account`(`account`,`accountid`,`userid`) VALUES('" + account + "','" + accountId + "','" + userId + "');";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:8500/banklist?serverTimezone=Europe/Moscow&useSSL=false", "root", "Maxkozlov2mailru");

            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();

            statement.executeUpdate(sqlAddUser);
            statement1.executeUpdate(sqlAddAccount);

            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        writer.println("<p> Sucsess </p>" );
    }
}
