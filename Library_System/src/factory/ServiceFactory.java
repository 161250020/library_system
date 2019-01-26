package factory;

import service.*;
import service.impl.*;
import service.ElectronicBooksManageService;
import service.OnlineReadModuleManageService;
/**
 * author：丁雯雯
 * time：2019/01/24
 * service层的factory
 */
public class ServiceFactory {
    public static AdminManageService getAdminManageService(){
        return AdminManageServiceImpl.getInstance();
    }

    public static BookManageService getBookManageService(){
        return BookManageServiceImpl.getInstance();
    }

    public static EditUserInfoOrderManageService getEditUserInfoOrderManageService(){
        return EditUserInfoOrderManageServiceImpl.getInstance();
    }

    public static ElectronicBooksManageService getElectronicBooksManageService(){
        return ElectronicBooksManageServiceImpl.getInstance();
    }

    public static OnlineReadModuleManageService getOnlineReadModuleManageService(){
        return OnlineReadModuleManageServiceImpl.getInstance();
    }

    public static UserManageService getUserManageService(){
        return UserManageServiceImpl.getInstance();
    }

    public static UserOrderManageService getUserOrderManageService(){
        return UserOrderManageServiceImpl.getInstance();
    }
}
