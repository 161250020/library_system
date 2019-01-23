package model;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 电子书籍的基本信息
 */
public class ElectronicBooks {
    public String id;//pk
    public String type;//图书类别（eg:文学类）
    public String name;//图书名称---以免后续需要检索
    public String author;//图书作者信息---以免后续需要检索
    public String publishCompany;//出版社---以免后续需要检索
    public String documentFormat;//文档格式
    public String filepath;//书籍内容存储的本地地址---这里默认是varchar(100)大小，
    // 书籍内容很大，然后数据库中存储书籍内容存放的URL，然后内容存储到另外的地方

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

    public String getDocumentFormat() {
        return documentFormat;
    }

    public void setDocumentFormat(String documentFormat) {
        this.documentFormat = documentFormat;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

}
