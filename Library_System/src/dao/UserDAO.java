package dao;

import model.User;

import java.util.ArrayList;

/**
 * Created by raychen on 2016/12/30.
 */
public interface UserDAO {
    //根据用户名查找某用户对象
    public User findUserByUsername(String username);
    //增加新用户
    public String addUser(User user);
    //删除某用户
    public String deleteUser(User user);
    //更新用户信息
    public String updateUser(User user);
    //查找所有用户
    public ArrayList<User> findAllUser();
}
