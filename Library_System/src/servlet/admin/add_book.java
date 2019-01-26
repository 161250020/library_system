package servlet.admin;

import factory.ServiceFactory;
import model.Book;
import service.BookManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_book")
public class add_book extends HttpServlet {
    private BookManageService bookManageService = ServiceFactory.getBookManageService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsps/admin/addBook.jsp");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("book_id");
        String name = req.getParameter("book_name");
        String type = req.getParameter("book_type");
        String author = req.getParameter("book_author");
        String publish = req.getParameter("book_publish");
        double fine = Double.parseDouble(req.getParameter("book_fine"));
        String state = req.getParameter("book_state");
        Book book = new Book();
        book.setId(bookId);
        book.setName(name);
        book.setType(type);
        book.setAuthor(author);
        book.setPublishCompany(publish);
        book.setFineMoneyPerDay(fine);
        book.setState(state);
        bookManageService.addBookInfo(book);
        resp.sendRedirect(req.getContextPath()+"/check_bookInfo");
    }
}