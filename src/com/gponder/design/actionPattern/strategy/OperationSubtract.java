package com.gponder.design.actionPattern.strategy;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/11 13:53
 */
public class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a-b;
    }
}
