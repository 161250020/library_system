package service.impl;

import service.UserOrderManageService;

import java.util.List;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理用户借书记录的方法
 */
public class UserOrderManageServiceImpl implements UserOrderManageService {
    @Override
    public List getInLentBooksById(String id) {
        return null;
    }

    @Override
    public List getAllLentBooksById(String id) {
        return null;
    }

    @Override
    public void payFineAndChangeTableOrderuser(String id, int fineDay) {

    }

    @Override
    public void lendBook(String userId, String bookId) {

    }
}
