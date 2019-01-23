package strategies.lendBooks;

import factory.DaoFactory;
import model.OnlineReadModule;

public class undergraduateStrategy implements Strategy {

    @Override
    public int maxNum() {
        return 10;
    }

    @Override
    public int maxPeriod() {
        return 60;
    }
}
