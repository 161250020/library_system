package strategies.readEBooks;

import model.OnlineReadModule;

public interface Strategy {
    //选择电子阅读组件的方法
    public OnlineReadModule choose();
}
