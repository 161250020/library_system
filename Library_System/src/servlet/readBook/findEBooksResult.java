package servlet.readBook;

import factory.ServiceFactory;
import model.ElectronicBooks;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 管理员的基本信息
 */
@WebServlet("/findEBooksResult")
public class findEBooksResult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet---findEBooksResult");

        HttpSession session=request.getSession(false);
        ServletContext context = getServletContext();

        //获得电子书籍的name符合的ebooks
        String inName=request.getParameter("book_name");
        ArrayList<ElectronicBooks> eBooksByName=new ArrayList();
        eBooksByName= (ArrayList<ElectronicBooks>) ServiceFactory.getElectronicBooksManageService().getElectronicBooksInfoByName(inName);
        for(int i=0;i<eBooksByName.size();i++){
            System.out.println("id："+eBooksByName.get(i).getId());
        }
        //获得电子书籍的ID符合的ebooks
        String inId=request.getParameter("book_id");
        ElectronicBooks eBookById=ServiceFactory.getElectronicBooksManageService().getElectronicBookInfoById(inId);
        System.out.println("id2："+eBookById.getId());

        if((!eBooksByName.contains(eBookById))&&(eBookById.getId()!=null)){//如果通过name需找到的电子书的结果不包含通过id需找到的电子书，且通过id需找到的电子书不为空值，就加上通过id需找到的电子书
            eBooksByName.add(eBookById);
        }
        session.setAttribute("allFoundEBooks", eBooksByName);
        context.getRequestDispatcher("/jsps/readBook/onlineReadBook.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
