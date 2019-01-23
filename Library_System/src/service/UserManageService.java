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
    public User getUserInfoByName(String name);

    /**
     * function：缴纳用户的罚款（用户name， 需缴纳的罚款的金额）---若用户余额不足，则缴纳完成之后余额为负值
     * change tables: user
     * */
    public void payAFine(String name, double fineMoney);

    /**
     * function：修改用户信息---密码（用户ID， 修改成为的密码）
     * change tables：user
     * */
    public void changePass(String name, String laterPass);

    /**
     * function：登录（用户name， 密码）---返回的String有以下几个原因：success login（成功登录），error password（密码错误），invalid username（该用户不存在）；
     * from tables：user
     * */
    public String login(String name, String password);

    /**
     * function：注册，注意一下原来的数据库当中是否有这个用户（name要唯一）
     * from tables：user
     * */
    //public void register(User newUser);
}
