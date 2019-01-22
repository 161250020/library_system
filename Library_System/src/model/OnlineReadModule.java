package model;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 书籍的基本信息
 */
public class OnlineReadModule {
    public String id;//pk
    public String documentFormat;//文档格式
    public String documentReader;//文档阅读器

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentFormat() {
        return documentFormat;
    }

    public void setDocumentFormat(String documentFormat) {
        this.documentFormat = documentFormat;
    }

    public String getDocumentReader() {
        return documentReader;
    }

    public void setDocumentReader(String documentReader) {
        this.documentReader = documentReader;
    }
}
