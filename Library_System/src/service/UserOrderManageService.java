package service;

import java.util.List;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理用户借书记录的方法
 */
public interface UserOrderManageService {

    /**
     * function：获得用户正在借阅的书籍
     * 根据用户的name获得用户正在借阅书籍的订单信息
     * */
    public List getInLentBooksById(String name);

    /**
     * function：获得用户借阅过的所有书籍
     * 根据用户的name获得用户借阅过的所有书籍的订单信息
     * */
    public List getAllLentBooksById(String name);

    /**
     * function：缴纳罚款，修改orderuser的订单的finDay和alreadyPay属性，输入（订单的ID，逾期日期fineDay）
     * change table: userorder
     * */
    public void payFineAndChangeTableUserorder(String id, int fineDay);

    /**
     * function：借书（用户的ID，书籍的id）---判断一下用户的余额是否>=0，若成立，则可以结束；反之，不可以借书；
     * change table: book（修改书籍的state），userorder（添加借书的订单）
     * */
    //public void lendBook(String userId, String bookId);
}
