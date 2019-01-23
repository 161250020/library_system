package service;

import model.User;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理管理员的基本信息
 */
public interface AdminManageService {
    /**
     * function：修改用户信息（修改成为的用户）---原用户ID和name，不变
     * change tables：user
     * */
    public void changeUserInfo(User newUser);

    /**
     * function：登录（管理员ID， 密码）
     * from tables：admin
     * */
    public boolean login(String name, String password);
}
