package service;

import model.User;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理管理员的基本信息
 */
public interface AdminManageService {
    /**
     * function：修改用户信息（原用户ID， 修改成为的用户）
     * change tables：user
     * */
    public void changeUserInfo(String id, User newUser);
}
