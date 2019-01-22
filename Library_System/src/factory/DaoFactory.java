package factory;

import dao.BookDAO;
import dao.UserDAO;
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

    public BookDAO getCourseSelectDAO(){ return new BookDAOImpl();
    }

}
