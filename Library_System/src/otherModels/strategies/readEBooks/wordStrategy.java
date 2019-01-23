package otherModels.strategies.readEBooks;

import factory.DaoFactory;
import model.OnlineReadModule;

public class wordStrategy implements Strategy {
    @Override
    public OnlineReadModule choose() {
        OnlineReadModule module= DaoFactory.getInstance().getOnlineReadModuleDAO().findModule("word");
        return module;
    }
}
