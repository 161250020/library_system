package service.impl;

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
    public void changeUserInfo(String id, User newUser) {

    }

    @Override
    public void login(String name, String password) {

    }
}
