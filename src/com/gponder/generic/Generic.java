package com.gponder.generic;

/**
 * 泛型
 * 类的泛型定义在类名的后边的<>
 * 方法的泛型定义在方法的返回值的前边的<>
 *
 */
public class Generic<T,G extends Generic<T,G>> {

    public <A> A method(A a,T t){
        return a;
    }
}
