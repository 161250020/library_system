package servlet.admin;

import factory.ServiceFactory;
import model.EditUserInfoOrder;
import model.User;
import service.AdminManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/check_user_changed")
public class check_user_changed extends HttpServlet {
    private AdminManageService adminManageService = ServiceFactory.getAdminManageService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EditUserInfoOrder> userList = adminManageService.getAllEdituserinfoorder();
        HttpSession session = request.getSession(false);
        session.setAttribute("editInfo",userList);
        response.sendRedirect(request.getContextPath()+"/jsps/admin/check_user_changed.jsp");
    }
}
