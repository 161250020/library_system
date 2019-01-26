package otherModels.strategies.lendBooks;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 本科生的strategy
 */
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
