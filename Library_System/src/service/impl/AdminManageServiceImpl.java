package service.impl;

import factory.DaoFactory;
import model.Admin;
import model.User;
import service.AdminManageService;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理管理员的基本信息
 */
public class AdminManageServiceImpl implements AdminManageService {

    public static AdminManageService adminManageService=new AdminManageServiceImpl();

    public static AdminManageService getInstance(){
        return adminManageService;
    }

    @Override
    public void changeUserInfo(User newUser) {
        DaoFactory.getInstance().getUserDAO().updateUser(newUser);
    }

    @Override
    public boolean login(String name, String password) {
        Admin admin=DaoFactory.getInstance().getAdminDAO().findAdminByName(name);
        if(admin.getPassword().equals(password))
            return true;
        else
            return false;
    }
}
