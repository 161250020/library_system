package strategies.lendBooks;

import model.OnlineReadModule;

public interface Strategy {
    //用户借书权限---借书最大数目
    public int maxNum();

    //用户借书权限---借书最长时间
    public int maxPeriod();
}
