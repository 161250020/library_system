package servlet.editInfo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 管理员的基本信息
 */
@WebServlet(name = "editUserInfo")
public class editUserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet---editUserInfo");

        HttpSession session=request.getSession(false);
        ServletContext context = getServletContext();

        context.getRequestDispatcher("/jsps/editInfo/editUserInfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
