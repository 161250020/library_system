package otherModels.strategies.lendBooks;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 教师的strategy
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
