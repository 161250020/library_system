package strategies.lendBooks;

import factory.DaoFactory;
import model.OnlineReadModule;

public class teacherStrategy implements Strategy {

    @Override
    public int maxNum() {
        return 30;
    }

    @Override
    public int maxPeriod() {
        return 180;
    }
}
