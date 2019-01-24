package servlet.admin;

import factory.ServiceFactory;
import model.User;
import service.AdminManageService;
import service.UserManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/check_user_data")
public class check_user_data extends HttpServlet {
    private AdminManageService adminManageService = ServiceFactory.getAdminManageService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<User> userList = adminManageService.getAllUsersInfo();
        session.setAttribute("userInfoList",userList);
        response.sendRedirect(request.getContextPath()+"/jsps/admin/check_user_data.jsp");
    }
}
