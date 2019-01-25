package otherModels.strategies.readEBooks;

import factory.DaoFactory;
import model.OnlineReadModule;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 管理员的基本信息
 */
public class wordStrategy implements Strategy {
    @Override
    public OnlineReadModule choose() {
        OnlineReadModule module= DaoFactory.getInstance().getOnlineReadModuleDAO().findModule("word");
        return module;
    }
}
