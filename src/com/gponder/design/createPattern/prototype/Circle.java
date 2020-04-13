package com.gponder.design.createPattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/9 18:34
 */
public class Circle extends Shape {

    public List<String> list = new ArrayList<>();

    public Circle() {
        type = "circle";
    }

    @Override
    public void draw() {
        System.out.println("draw circle");
    }
}
