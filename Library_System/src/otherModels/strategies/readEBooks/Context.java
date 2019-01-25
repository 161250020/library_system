package otherModels.strategies.readEBooks;

import model.OnlineReadModule;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 管理员的基本信息
 */
public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        super();
        this.strategy=strategy;
    }

    //选择电子阅读的组件
    public OnlineReadModule chooseModule(){
        return this.strategy.choose();
    }

}
