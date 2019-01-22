package service;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理用户修改基本信息的方法
 */
public interface EditUserInfoOrderManageService {
    /**
     * function：添加修改用户信息---密码（用户ID, 修改前密码prePass, 修改成为的密码laterPass）
     * change tables：edituserinfoorder
     * */
    public void changePassAndChangeTableEdituserinfoorder(String id, String prePass, String laterPass);
}
