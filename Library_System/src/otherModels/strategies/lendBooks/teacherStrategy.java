package otherModels.strategies.lendBooks;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 管理员的基本信息
 */
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
