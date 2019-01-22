package dao;

import model.OnlineReadModule;

public interface OnlineReadModuleDAO {
    //根据文件类型查找组件对象
    public OnlineReadModule findModule(String documentFormat);
}
