package otherModels.strategies.readEBooks;

import model.OnlineReadModule;

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
