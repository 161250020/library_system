package strategies.lendBooks;

import factory.DaoFactory;
import model.OnlineReadModule;
import model.User;

import java.util.ArrayList;

public class postgraduateStrategy implements Strategy {

    @Override
    public int maxNum() {
        return 20;
    }

    @Override
    public int maxPeriod() {
        return 120;
    }
}
