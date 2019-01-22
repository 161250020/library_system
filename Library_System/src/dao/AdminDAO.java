package dao;

import model.Admin;

public interface AdminDAO {
    public Admin findAdminByName(String name);
}
