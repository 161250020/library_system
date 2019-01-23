package otherModels.strategies.lendBooks;

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
