package dao;

import model.Book;

import java.util.ArrayList;

public interface BookDAO {
    //根据书籍id查找书籍对象
    public Book findBookByBookId(String id);
    //新增书籍
    public String addBook(Book book);
    //删除某书籍
    public String deleteBook(Book book);
    //更新书籍信息
    public String updateBook(Book book);
    //查找所有书籍
    public ArrayList<Book> findAllBook();
}
