package dao;

import model.EditUserInfoOrder;

import java.util.ArrayList;

public interface EditUserInfoOrderDAO {
    //增加更改个人信息记录
    public String addEditUserInfoOrder(EditUserInfoOrder editUserInfoOrder);
    //查找所有该记录
    public ArrayList<EditUserInfoOrder> getAllEditUserInfoOrder();
}
