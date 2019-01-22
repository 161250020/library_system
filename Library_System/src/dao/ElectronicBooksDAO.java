package dao;

import model.ElectronicBooks;

import java.util.ArrayList;

public interface ElectronicBooksDAO {
    //查找所有电子书
    public ArrayList<ElectronicBooks> getAllElectronicBooks();

    //更新电子书信息
    public String updateElectronicBooks(ElectronicBooks e);

    //新增电子书
    public String addElectronicBooks(ElectronicBooks e);

    //删除电子书
    public String deleteElectronicBooks(ElectronicBooks e);

    //根据id查找某电子书对象
    public ElectronicBooks findElectronicBooks(String id);
}
