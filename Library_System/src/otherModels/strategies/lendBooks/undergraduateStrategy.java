package otherModels.strategies.lendBooks;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 管理员的基本信息
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
