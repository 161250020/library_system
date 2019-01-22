package factory;

import dao.*;
import dao.impl.*;
import model.Book;

public class DaoFactory {
    private static DaoFactory factory = new DaoFactory();
    private DaoFactory(){}
    public static DaoFactory getInstance() {
        return factory;
    }

    public UserDAO getUserDAO(){
        return new UserDAOImpl();
    }

    public BookDAO getBookDAO(){ return new BookDAOImpl(); }

    public AdminDAO getAdminDAO(){ return  new AdminDAOImpl(); }

    public ElectronicBooksDAO getElectronicBooksDAO(){return  new ElectronicBooksDAOImpl();}

    public EditUserInfoOrderDAO getEditUserInfoOrderDAO(){return new EditUserInfoOrderDAOImpl();}
}
