package service;

import model.ElectronicBooks;
import model.OnlineReadModule;

import java.util.List;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理电子书的方法
 */
public interface ElectronicBooksManageService {
    /**
     * function：根据电子书的ID获得书籍的基本信息
     * from tables: electronicbooks
     * */
    public ElectronicBooks getElectronicBookInfoById(String id);

    /**
     * function：根据电子书的名称获得书籍的基本信息
     * from tables: electronicbooks
     * 返回的结果：可能为多本电子书
     * */
    public List getElectronicBooksInfoByName(String name);



}
