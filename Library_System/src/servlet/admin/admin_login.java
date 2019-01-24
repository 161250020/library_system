package servlet.admin;

import factory.ServiceFactory;
import service.AdminManageService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin_login")
public class admin_login extends HttpServlet {
    private AdminManageService adminManageService = ServiceFactory.getAdminManageService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        ServletContext context = getServletContext();
        if (null != req.getParameter("Logout")) {
            if (null != session) {
                session.invalidate();
                session = null;
            }
        }


        context.getRequestDispatcher("/jsps/admin/login_admin.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession(true);
        ServletContext context = getServletContext();

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        boolean loginResult= adminManageService.login(username, password);
        if(loginResult){//登录成功
            //设置username的cookie
            Cookie[] cookies=request.getCookies();
            Cookie cookie=null;
            boolean haveUsernameCookie=false;//是否有username的cookie
            if(null!=cookies){
                for(int i=0;i<cookies.length;i++){
                    cookie=cookies[i];
                    if(cookie.getName().equals("username")){
                        haveUsernameCookie=true;
                        break;
                    }
                }
            }

            if(haveUsernameCookie){  //如果有username的cookie
                cookie.setValue(username);
                response.addCookie(cookie);
            }else{
                Cookie c=new Cookie("username", username);
                response.addCookie(c);
            }

            session.setAttribute("username",username);
            //跳转到个人主页
            response.sendRedirect(request.getContextPath()+"/check_user_data");

        }
        else{//密码错误/用户名不存在
            request.setAttribute("loginInfo", "无该管理员账号或密码错误！");
            context.getRequestDispatcher("/jsps/admin/login_admin.jsp").forward(request, response);
        }
    }

}
