package com.gponder.design.createPattern.prototype;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/9 18:27
 * 克隆变量使用原对象的变量
 */
public class Prototype {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Circle c = (Circle)circle.clone();
        System.out.println(c.getType());
        System.out.println(circle.list.equals(c.list));
    }
}
