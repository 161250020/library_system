package service.impl;

import factory.DaoFactory;
import model.Book;
import service.BookManageService;

import java.util.List;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理书籍的方法
 */
public class BookManageServiceImpl implements BookManageService {

    public static BookManageService bookManageService=new BookManageServiceImpl();

    public static BookManageService getInstance(){
        return bookManageService;
    }
    @Override
    public Book getBookInfoById(String id) {
        Book book=DaoFactory.getInstance().getBookDAO().findBookByBookId(id);
        return book;
    }

    @Override
    public void addBookInfo(Book newBook) {
        DaoFactory.getInstance().getBookDAO().addBook(newBook);
    }

    @Override
    public List getAllBooksInfo() {
        List ret=DaoFactory.getInstance().getBookDAO().findAllBook();
        return ret;
    }

    @Override
    public void updateBookInfo(Book book) {
        DaoFactory.getInstance().getBookDAO().updateBook(book);
    }

//    @Override
//    public void lendBook(String userId, String bookId) {
//
//    }
}
