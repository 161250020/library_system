package otherModels.strategies.lendBooks;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy){
        super();
        this.strategy=strategy;
    }

    //用户借书权限---借书最大数目
    public int maxNum(){
        return this.strategy.maxNum();
    }

    //用户借书权限---借书最长时间
    public int maxPeriod(){
        return this.strategy.maxPeriod();
    }
}
