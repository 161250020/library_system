package strategies.readEBooks;

import factory.DaoFactory;
import model.OnlineReadModule;

public class pdfStrategy implements Strategy {
    @Override
    public OnlineReadModule choose() {
        OnlineReadModule module= DaoFactory.getInstance().getOnlineReadModuleDAO().findModule("pdf");
        return module;
    }
}
