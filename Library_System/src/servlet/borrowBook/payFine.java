package servlet.borrowBook;

import factory.ServiceFactory;
import model.UserOrder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/payFine")
public class payFine extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet---payFine");

        HttpSession session=request.getSession(false);

        //获得username的cookie
        Cookie[] cookies=request.getCookies();
        Cookie cookie=null;
        if(null!=cookies){
            for(int i=0;i<cookies.length;i++){
                cookie=cookies[i];
                if(cookie.getName().equals("username")){
                    break;
                }
            }
        }

        //缴纳罚款
        //修改用户金额
        double sumFineMoney= (double) session.getAttribute("sumFineMoney");
        ServiceFactory.getUserManageService().payAFine(cookie.getValue(), sumFineMoney);
        session.setAttribute("sumFineMoney",0);
        //修改userorder的信息---订单的状态---罚款是否已经缴纳
        ArrayList<UserOrder> arrAllLentBooksUserOrder= (ArrayList<UserOrder>) session.getAttribute("allLentBooksUserOrder");
        for(int i=0;i<arrAllLentBooksUserOrder.size();i++){
            if(arrAllLentBooksUserOrder.get(i).getFineDay()!=-1){//不为未还书的订单的信息
                ServiceFactory.getUserOrderManageService()
                        .payFineAndChangeTableUserorder(arrAllLentBooksUserOrder.get(i).getId());
            }
        }

        //跳转到servlet，重写borrowHistory.jsp页面的数据
        response.sendRedirect(request.getContextPath()+"/borrowHistory");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
