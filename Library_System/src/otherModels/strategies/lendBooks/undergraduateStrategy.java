package otherModels.strategies.lendBooks;

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
