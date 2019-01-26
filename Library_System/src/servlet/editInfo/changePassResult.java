package servlet.editInfo;

import factory.ServiceFactory;
import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 修改密码的结果的servlet
 */
@WebServlet("/changePassResult")
public class changePassResult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet---changePassResult");

        HttpSession session=request.getSession(false);
        ServletContext context = getServletContext();

        String changePassResult="";//最终修改密码的结果
        String rawPass=request.getParameter("pre_pass");
        String newPass1=request.getParameter("new_pass");
        String newPass2=request.getParameter("reInputNew_pass");

        //两次输入的密码不同
        if(!newPass1.equals(newPass2)){
            changePassResult="密码修改结果：两次输入密码不同！";
        }
        else{//两次输入的密码相同
            //原密码输入错误
            User u= (User) session.getAttribute("userInfo");
            if(!u.getPassword().equals(rawPass)){//输入的原密码错误
                changePassResult="密码修改结果：原密码输入错误！";
            }
            else{
                changePassResult="密码修改结果：修改成功！";

                //调用后端方法修改密码
                //table user 的密码的修改
                ServiceFactory.getUserManageService().changePass(u.getName(), newPass1);
                //table edituserinfoorder 的密码修改的订单的增加
                ServiceFactory.getEditUserInfoOrderManageService().changePassAndChangeTableEdituserinfoorder(u.getId(), rawPass, newPass1);
            }
        }

        request.setAttribute("changePassResult",changePassResult);
        context.getRequestDispatcher("/jsps/editInfo/editUserInfo.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
