package service;

import model.OnlineReadModule;

import java.util.List;

/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理在线阅读电子书组件的方法
 */
public interface OnlineReadModuleManageService {
    /**
     * function：根据文档格式获得文档阅读器
     * from tables: onlinereadmodule
     * 按理说文档格式对应的文档阅读器不止一个，应该返回List（OnlineReadModule），但是这里简单写
     * */
    public OnlineReadModule getOnlineReadModuleByDocumentFormat(String documentFormat);
}
