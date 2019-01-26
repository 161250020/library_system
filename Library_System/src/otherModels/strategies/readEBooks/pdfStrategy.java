package otherModels.strategies.readEBooks;

import factory.DaoFactory;
import model.OnlineReadModule;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 阅读PDF电子书选择PDF组件
 */
public class pdfStrategy implements Strategy {
    @Override
    public OnlineReadModule choose() {
        OnlineReadModule module= DaoFactory.getInstance().getOnlineReadModuleDAO().findModule("pdf");
        return module;
    }
}
