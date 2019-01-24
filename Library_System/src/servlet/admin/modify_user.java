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

@WebServlet("/modify_user")
public class modify_user extends HttpServlet {
    private AdminManageService adminManageService = ServiceFactory.getAdminManageService();
    private UserManageService userManageService = ServiceFactory.getUserManageService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("user_id");
        String name = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        String type = request.getParameter("user_type");
        int MaxNum = Integer.parseInt(request.getParameter("user_MaxNum"));
        int MaxP = Integer.parseInt(request.getParameter("user_MaxPeriod"));
        double money = Double.parseDouble(request.getParameter("user_money"));
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setType(type);
        user.setPassword(password);
        user.setMaxNum(MaxNum);
        user.setMaxPeriod(MaxP);
        user.setMoney(money);
        adminManageService.changeUserInfo(user);
        response.sendRedirect(request.getContextPath()+"/check_user_data");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = userManageService.getUserInfoByName(request.getParameter("change"));
        HttpSession session = request.getSession(false);
        session.setAttribute("user",user);
        response.sendRedirect("/jsps/admin/modify_user.jsp");
    }
}
