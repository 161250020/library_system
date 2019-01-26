package otherModels.strategies.lendBooks;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 借书信息的context
 */
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
