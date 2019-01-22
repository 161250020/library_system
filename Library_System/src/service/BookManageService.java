package service;

import model.Book;

import java.util.List;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理书籍的方法
 */
public interface BookManageService {

    /**
     * function：根据书籍的ID获得书籍的基本信息
     * from tables: book
     * */
    public Book getBookInfoById(String id);

    /**
     * function：添加书籍的信息入库
     * change tables: book
     * */
    public void addBookInfo(Book newBook);

    /**
     * function：借书（用户的ID，书籍的id）---判断一下用户的余额是否>=0，若成立，则可以结束；反之，不可以借书；
     * change table: book（修改书籍的state），userorder（添加借书的订单）
     * */
    public void lendBook(String userId, String bookId);
}
