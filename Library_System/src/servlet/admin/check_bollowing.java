package servlet.admin;

import factory.ServiceFactory;
import model.UserOrder;
import service.AdminManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/check_bollowing")
public class check_bollowing extends HttpServlet {
    private AdminManageService adminManageService = ServiceFactory.getAdminManageService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<UserOrder> list = adminManageService.getAllUserorder();
        session.setAttribute("userOrder",list);
        response.sendRedirect(request.getContextPath()+"/jsps/admin/check_bollowing.jsp");
    }
}
