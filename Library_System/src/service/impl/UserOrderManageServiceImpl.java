package service.impl;

import factory.DaoFactory;
import model.User;
import model.UserOrder;
import service.UserOrderManageService;

import java.util.ArrayList;
import java.util.List;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理用户借书记录的方法
 */
public class UserOrderManageServiceImpl implements UserOrderManageService {

    public static UserOrderManageService userOrderManageService=new UserOrderManageServiceImpl();

    public static UserOrderManageService getInstance(){
        return userOrderManageService;
    }

    @Override
    public List getInLentBooksById(String name) {
        User u=DaoFactory.getInstance().getUserDAO().findUserByUsername(name);
        ArrayList<UserOrder> arrUserOrder= DaoFactory.getInstance().getUserOrderDAO().getAllUserOrder(u);

        List inLentBooks=new ArrayList();
        for(int i=0;i<arrUserOrder.size();i++){
            if(arrUserOrder.get(i).getFineDay()==-1){
                inLentBooks.add(arrUserOrder.get(i));
            }
        }

        return inLentBooks;
    }

    @Override
    public List getAllLentBooksById(String name) {
        User u=DaoFactory.getInstance().getUserDAO().findUserByUsername(name);
        ArrayList<UserOrder> arrUserOrder= DaoFactory.getInstance().getUserOrderDAO().getAllUserOrder(u);

        List lentBooks=new ArrayList();
        for(int i=0;i<arrUserOrder.size();i++){
            lentBooks.add(arrUserOrder.get(i));
        }

        return lentBooks;
    }

    @Override
    public void payFineAndChangeTableUserorder(String id, int fineDay) {
        //













    }

//    @Override
//    public void lendBook(String userId, String bookId) {
//
//    }
}
