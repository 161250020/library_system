package otherModels.strategies.lendBooks;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 借书信息的strategy
 */
public interface Strategy {
    //用户借书权限---借书最大数目
    public int maxNum();

    //用户借书权限---借书最长时间
    public int maxPeriod();
}
