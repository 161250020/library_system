package model;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理员的基本信息
 */
public class admin {
    public String id;//pk
    public String name;//名称
    public String password;//密码
    //public String level;//等级---以免后续管理员分级，有的管理员会有更高级的功能（eg：添加有特殊功能的用户）


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
}
