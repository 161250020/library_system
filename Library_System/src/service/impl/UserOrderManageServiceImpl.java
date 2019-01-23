package service.impl;

import factory.DaoFactory;
import model.User;
import model.UserOrder;
import service.UserOrderManageService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        UserOrder uo=DaoFactory.getInstance().getUserOrderDAO().getUserOrder(id);
        //当前时间
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStringToParse = bartDateFormat.format(nowTime);
        java.util.Date date = null;
        try {
            date = bartDateFormat.parse(dateStringToParse);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        uo.setReturnTime(sqlDate);
        uo.setFineDay(fineDay);
        uo.setAlreadyPay(1);
        DaoFactory.getInstance().getUserOrderDAO().updateUserOrder(uo);
    }

//    @Override
//    public void lendBook(String userId, String bookId) {
//
//    }
}
