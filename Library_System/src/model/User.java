package model;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 用户（本科生，研究生，教师）的基本信息
 */
public class User {
    public String id;//pk
    public String name;//名称
    public String password;//密码
    public String type;//本科生（undergraduate），研究生（postgraduate），教师（teacher）
    public int MaxNum;//借书的最大本数
    public int MaxPeriod;//结束的最大时长
    public double money;//用户的总金额数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxNum() {
        return MaxNum;
    }

    public void setMaxNum(int maxNum) {
        MaxNum = maxNum;
    }

    public int getMaxPeriod() {
        return MaxPeriod;
    }

    public void setMaxPeriod(int maxPeriod) {
        MaxPeriod = maxPeriod;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
