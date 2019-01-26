package otherModels.strategies.readEBooks;

import model.OnlineReadModule;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 阅读电子书选择组件的strategy
 */
public interface Strategy {
    //选择电子阅读组件的方法
    public OnlineReadModule choose();
}
