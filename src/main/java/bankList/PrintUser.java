package bankList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by k-max1m on 10.12.2019.
 */
public class PrintUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        ArrayList<User> allUser = BankListAllPerson.getAllUser();
        httpServletRequest.setAttribute("allUser", allUser);

        getServletContext().getRequestDispatcher("/view/printUser.jsp").forward(httpServletRequest,httpServletResponse);
    }

}
