package model;

import java.sql.Date;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 用户修改个人信息的记录
 */
public class EditUserInfoOrder {
    public String id;//pk
    public String userId;//修改信息的用户的id
    public Date changeTime;//修改信息的日期，数据库中的类型为：datetime
    public String prePass;//修改前的密码
    public String laterPass;//修改后密码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getLaterPass() {
        return laterPass;
    }

    public void setLaterPass(String laterPass) {
        this.laterPass = laterPass;
    }

    public String getPrePass() {
        return prePass;
    }

    public void setPrePass(String prePass) {
        this.prePass = prePass;
    }

}
