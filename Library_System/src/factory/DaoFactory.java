package factory;

import dao.AdminDAO;
import dao.BookDAO;
import dao.UserDAO;
import dao.impl.AdminDAOImpl;
import dao.impl.BookDAOImpl;
import dao.impl.UserDAOImpl;
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

    public BookDAO getBookDAO(){ return new BookDAOImpl();}

    public AdminDAO getAdminDAO(){ return  new AdminDAOImpl();    }


}
