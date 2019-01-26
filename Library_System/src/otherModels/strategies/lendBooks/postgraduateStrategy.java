package otherModels.strategies.lendBooks;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 研究生的strategy
 */
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
