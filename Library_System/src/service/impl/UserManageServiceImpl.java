package service.impl;

import model.User;
import service.UserManageService;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理用户的方法
 */
public class UserManageServiceImpl implements UserManageService {

    public static UserManageService userManageService=new UserManageServiceImpl();

    public static UserManageService getInstance(){
        return userManageService;
    }

    @Override
    public User getUserInfoByName(String name) {
        return null;
    }

    @Override
    public void payAFine(String id, double fineMoney) {

    }

    @Override
    public void changePass(String id, String laterPass) {

    }

    @Override
    public void login(String name, String password) {

    }

//    @Override
//    public void register(User newUser) {
//
//    }
}
