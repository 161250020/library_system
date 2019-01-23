package service.impl;

import factory.DaoFactory;
import model.OnlineReadModule;
import service.OnlineReadModuleManageService;
/**
 * author：丁雯雯
 * time：2019/01/22
 * 管理在线阅读电子书组件的方法
 */
public class OnlineReadModuleManageServiceImpl implements OnlineReadModuleManageService {

    public static OnlineReadModuleManageService onlineReadModuleManageService=new OnlineReadModuleManageServiceImpl();

    public static OnlineReadModuleManageService getInstance(){
        return onlineReadModuleManageService;
    }

    @Override
    public OnlineReadModule getOnlineReadModuleByDocumentFormat(String documentFormat) {
        OnlineReadModule orm=new OnlineReadModule();
        orm= DaoFactory.getInstance().getOnlineReadModuleDAO().findModule(documentFormat);
        return orm;
    }
}
