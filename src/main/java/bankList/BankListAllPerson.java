package bankList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by k-max1m on 07.12.2019.
 */
public class BankListAllPerson extends HttpServlet {

    private static ArrayList<User> allUser;

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        Connection con = null;
        allUser = new ArrayList<User>();
        PrintWriter writer = httpServletResponse.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:8500/banklist?serverTimezone=Europe/Moscow&useSSL=false", "root", "Maxkozlov2mailru");

            Statement statement = con.createStatement();
            Statement statement1 = con.createStatement();
            ResultSet resultSetUser = statement.executeQuery("SELECT * FROM banklist.user");
            ResultSet resultSetAccoun = statement1.executeQuery("SELECT * FROM banklist.account");

            while (resultSetUser.next() && resultSetAccoun.next()) {
                String name = resultSetUser.getString("name");
                String sureName = resultSetUser.getString("sureName");
                int userId = Integer.parseInt(resultSetUser.getString("userid"));
                int account = resultSetAccoun.getInt("account");
                int accountId = resultSetAccoun.getInt("accountId");
                allUser.add(new User(userId,accountId,account,name,sureName));
            }

            String nameMore = allUser.get(0).getName();
            int sumAccount = allUser.get(0).getAccount();
            for (int i = 0; i < allUser.size() - 1; i++) {
                if(allUser.get(i).getAccount() < allUser.get(i+1).getAccount() ) {
                    nameMore = allUser.get(i+1).getName();
                }
                sumAccount+= allUser.get(i+1).getAccount();
            }

            httpServletRequest.setAttribute("mas",allUser);
            httpServletRequest.setAttribute("nameMore",nameMore);
            httpServletRequest.setAttribute("sumAccount",sumAccount);

            getServletContext().getRequestDispatcher("/view/bankListAll.jsp").forward(httpServletRequest,httpServletResponse);

            statement.close();
            statement1.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getAllUser() {
        return allUser;
    }
}
