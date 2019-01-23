package service.impl;

import factory.DaoFactory;
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
        User u= DaoFactory.getInstance().getUserDAO().findUserByUsername(name);
        return u;
    }

    @Override
    public void payAFine(String name, double fineMoney) {
        User u=DaoFactory.getInstance().getUserDAO().findUserByUsername(name);
        double preMon=u.getMoney();
        u.setMoney(preMon-fineMoney);
        DaoFactory.getInstance().getUserDAO().updateUser(u);
    }

    @Override
    public void changePass(String name, String laterPass) {
        User u=DaoFactory.getInstance().getUserDAO().findUserByUsername(name);
        u.setPassword(laterPass);
        DaoFactory.getInstance().getUserDAO().updateUser(u);
    }

    @Override
    public String login(String name, String password) {
        User u=null;
        u=DaoFactory.getInstance().getUserDAO().findUserByUsername(name);
        if(u==null){
            return "invalid username";
        }
        else{
            if(u.getPassword().equals(password))
                return "success login";
            else
                return "error password";
        }
    }

//    @Override
//    public void register(User newUser) {
//
//    }
}
