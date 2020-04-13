package com.gponder.design.createPattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/9 17:55
 */
public class Meal {
    private List<Food> foods = new ArrayList<>();

    public void addFood(Food food){
        foods.add(food);
    }

    public double getBill(){
        double bill = 0;
        for (Food food:foods){
            bill+=food.getPrice();
        }
        return bill;
    }

    public void showFood(){
        for (Food food:foods){
            System.out.println(food.getName());
            System.out.println(food.getPacking().packet());
            System.out.println(food.getPrice());
        }
    }
}
