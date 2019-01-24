package servlet.admin;

import factory.ServiceFactory;
import model.Book;
import service.BookManageService;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/check_bookInfo")
public class check_bookInfo extends HttpServlet {
    private BookManageService bookManageService = ServiceFactory.getBookManageService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        List<Book> bookList = bookManageService.getAllBooksInfo();
        session.setAttribute("bookInfoList",bookList);
        response.sendRedirect("/jsps/admin/check_bookInfo.jsp");
    }
}
