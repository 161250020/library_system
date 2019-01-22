package service.impl;

import model.ElectronicBooks;
import service.ElectronicBooksManageService;

import java.util.List;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理电子书的方法
 */
public class ElectronicBooksManageServiceImpl implements ElectronicBooksManageService {

    public static ElectronicBooksManageService electronicBooksManageService=new ElectronicBooksManageServiceImpl();

    public static ElectronicBooksManageService getInstance(){
        return electronicBooksManageService;
    }

    @Override
    public ElectronicBooks getElectronicBookInfoById(String id) {
        return null;
    }

    @Override
    public List getElectronicBooksInfoByName(String name) {
        return null;
    }
}
