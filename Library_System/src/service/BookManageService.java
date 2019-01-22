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


}
