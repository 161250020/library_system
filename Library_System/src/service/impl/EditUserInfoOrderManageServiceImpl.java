package service.impl;

import factory.DaoFactory;
import model.EditUserInfoOrder;
import service.EditUserInfoOrderManageService;

import java.sql.Date;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理用户修改基本信息的方法
 */
public class EditUserInfoOrderManageServiceImpl implements EditUserInfoOrderManageService {

    public static EditUserInfoOrderManageService editUserInfoOrderManageService=new EditUserInfoOrderManageServiceImpl();

    public static EditUserInfoOrderManageService getInstance(){
        return editUserInfoOrderManageService;
    }

    @Override
    public void changePassAndChangeTableEdituserinfoorder(String id, String prePass, String laterPass) {
        EditUserInfoOrder e=new EditUserInfoOrder();
        String uuid= UUID.randomUUID().toString();
        e.setId(uuid);
        e.setUserId(id);
        e.setPrePass(prePass);
        e.setLaterPass(laterPass);
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
        e.setChangeTime(sqlDate);
        DaoFactory.getInstance().getEditUserInfoOrderDAO().addEditUserInfoOrder(e);
    }
}
