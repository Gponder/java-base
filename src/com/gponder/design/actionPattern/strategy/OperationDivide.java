package com.gponder.design.actionPattern.strategy;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/11 16:30
 */
public class OperationDivide implements Strategy {
    @Override
    public int doOperation(int a, int b) {
        return a/b;
    }
}
