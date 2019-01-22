package dao;

import model.Book;

import java.util.ArrayList;

public interface BookDAO {
    public Book findBookByBookId(String id);
    public String addBook(Book book);
    public String deleteBook(Book book);
    public String updateBook(Book book);
    public ArrayList<Book> findAllBook();
}
