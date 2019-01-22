package dao;

import model.Admin;

public interface AdminDAO {
    //根据管理员名查找管理员对象
    public Admin findAdminByName(String name);
}
