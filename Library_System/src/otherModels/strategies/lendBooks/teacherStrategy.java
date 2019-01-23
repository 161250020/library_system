package otherModels.strategies.lendBooks;

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
