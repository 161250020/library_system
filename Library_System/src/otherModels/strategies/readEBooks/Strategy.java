package otherModels.strategies.readEBooks;

import model.OnlineReadModule;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 管理员的基本信息
 */
public interface Strategy {
    //选择电子阅读组件的方法
    public OnlineReadModule choose();
}
