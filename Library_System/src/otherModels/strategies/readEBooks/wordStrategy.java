package otherModels.strategies.readEBooks;

import factory.DaoFactory;
import model.OnlineReadModule;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 阅读Word电子书选择Word组件
 */
public class wordStrategy implements Strategy {
    @Override
    public OnlineReadModule choose() {
        OnlineReadModule module= DaoFactory.getInstance().getOnlineReadModuleDAO().findModule("word");
        return module;
    }
}
