package servlet.users;

import factory.ServiceFactory;

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
@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet---Login");

        HttpSession session=request.getSession(false);
        ServletContext context = getServletContext();

        //清空session
        session.invalidate();
        session=null;

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        String loginResult= ServiceFactory.getUserManageService().login(username, password);
        if(loginResult.equals("success login")){//登录成功
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

            if(haveUsernameCookie){//如果有username的cookie
                cookie.setValue(username);
                response.addCookie(cookie);
            }else{
                Cookie c=new Cookie("username", username);
                response.addCookie(c);
            }

            //跳转到个人主页
            response.sendRedirect(request.getContextPath()+"/userInfo");

        }
        else{//密码错误/用户名不存在
            request.setAttribute("loginInfo", loginResult);
            context.getRequestDispatcher("/jsps/users/Login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
