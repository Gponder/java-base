package com.gponder.design.actionPattern.strategy;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/11 16:31
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }


    public int executeStrategy(int a, int b){
        return strategy.doOperation(a,b);
    }


    public static void main(String[] args) {
        int result = new Context(new OperationDivide()).executeStrategy(10,1);
        System.out.println(result);
    }
}
