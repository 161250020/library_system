package service.impl;

import factory.DaoFactory;
import model.ElectronicBooks;
import service.ElectronicBooksManageService;

import java.util.ArrayList;
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
        ArrayList<ElectronicBooks> arr=DaoFactory.getInstance().getElectronicBooksDAO().getAllElectronicBooks();
        ElectronicBooks ebook=new ElectronicBooks();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getId().equals(id)){
                ebook=arr.get(i);
            }
        }
        return ebook;
    }

    @Override
    public List getElectronicBooksInfoByName(String name) {
        ArrayList<ElectronicBooks> arr=DaoFactory.getInstance().getElectronicBooksDAO().getAllElectronicBooks();
        ElectronicBooks ebook=new ElectronicBooks();
        List retArr=new ArrayList();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).getName().equals(name)){
                retArr.add(arr.get(i));
            }
        }
        return retArr;
    }
}
