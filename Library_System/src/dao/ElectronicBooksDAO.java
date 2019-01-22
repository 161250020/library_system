package dao;

import model.ElectronicBooks;

import java.util.ArrayList;

public interface ElectronicBooksDAO {
    //查找所有电子书
    public ArrayList<ElectronicBooks> getAllElectronicBooks();
}
