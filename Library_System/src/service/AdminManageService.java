package service;

import model.User;

import java.util.List;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理管理员的基本信息
 */
public interface AdminManageService {
    /**
     * function：修改用户信息（修改成为的用户）
     * change tables：user
     * */
    public void changeUserInfo(User newUser);

    /**
     * function：登录（管理员ID， 密码）
     * from tables：admin
     * */
    public boolean login(String name, String password);

    /**
     * function：获取所有用户的信息
     * from tables：user
     * */
    public List getAllUsersInfo();

    /**
     * function：获取所有借阅信息
     * from tables：userorder
     * */
    public List getAllUserorder();

    /**
     * function：获取所有用户信息改变记录
     * from tables：edituserinfoorder
     * */
    public List getAllEdituserinfoorder();
}
