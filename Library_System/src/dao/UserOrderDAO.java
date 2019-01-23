package dao;

import model.User;
import model.UserOrder;

import java.util.ArrayList;

public interface UserOrderDAO {
    //新增借阅记录
    public String addUserOrder(UserOrder userOrder);
    //查找所有用户借阅记录
    public ArrayList<UserOrder> getAllUserOrder();
    //查找某用户的借阅记录
    public ArrayList<UserOrder> getAllUserOrder(User user);

    //根据id查找某借阅记录
    public UserOrder getUserOrder(String id);
}
