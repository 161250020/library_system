package model;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 书籍的基本信息
 */
public class Book {
    public String id;//pk
    public String type;//图书类别（eg:文学类）
    public String name;//图书名称---以免后续需要检索
    public String author;//图书作者信息---以免后续需要检索
    public String publishCompany;//出版社---以免后续需要检索
    public String state;//借阅状态；in：未借出；out：已借出；
    public double fineMoneyPerDay;//逾期罚款每天的钱数---以免不同人罚款的每天的金额不同

    public double getFineMoneyPerDay() {
        return fineMoneyPerDay;
    }

    public void setFineMoneyPerDay(double fineMoneyPerDay) {
        this.fineMoneyPerDay = fineMoneyPerDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishCompany() {
        return publishCompany;
    }

    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
