package service;

import model.User;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理用户的方法
 */
public interface UserManageService {
    /**
     * function：根据用户ID获得用户的基本信息
     * from tables: user
     * */
    public User getUserInfoById(String id);

    /**
     * function：缴纳用户的罚款（用户ID， 需缴纳的罚款的金额）
     * change tables: user, userorder
     * */
    public void payAFine(String id, double fineMoney);

    /**
     * function：修改用户信息---密码（用户ID， 修改成为的密码）
     * change tables：user， edituserinfoorder
     * */
    public void changePass(String id, String laterPass);

    /**
     * function：登录（用户name， 密码）
     * from tables：user
     * */
    public void login(String name, String password);

    /**
     * function：注册，注意一下原来的数据库当中是否有这个用户（name要唯一）
     * from tables：user
     * */
    //public void register(User newUser);
}
