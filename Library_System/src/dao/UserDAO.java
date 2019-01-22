package dao;

import model.User;

import java.util.ArrayList;

/**
 * Created by raychen on 2016/12/30.
 */
public interface UserDAO {
    public User findUserByUsername(String username);
    public String addUser(User user);
    public String deleteUser(User user);
    public String updateUser(User user);
    public ArrayList<User> findAllUser();
}
