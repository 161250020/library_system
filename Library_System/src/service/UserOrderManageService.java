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
     * 根据用户的id获得用户正在借阅书籍的订单信息
     * */
    public List getInLentBooksById(String id);

    /**
     * function：获得用户借阅过的所有书籍
     * 根据用户的id获得用户借阅过的所有书籍的订单信息
     * */
    public List getAllLentBooksById(String id);

    /**
     * function：缴纳罚款，修改orderuser的订单的finDay和alreadyPay属性，输入（订单的ID，逾期日期fineDay）
     * change table: userorder
     * */
    public void payFineAndChangeTableOrderuser(String id, int fineDay);

}
