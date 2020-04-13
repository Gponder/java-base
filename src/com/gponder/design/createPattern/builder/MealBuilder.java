package com.gponder.design.createPattern.builder;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/8 15:58
 * 建造者模式
 */
public class MealBuilder {
    public Meal beefCoCaMeal(){
        Meal meal = new Meal();
        meal.addFood(new CoCa());
        meal.addFood(new BeefBurger());
        return meal;
    }
    public Meal chickenPepsiMeal(){
        Meal meal = new Meal();
        meal.addFood(new Pepsi());
        meal.addFood(new ChickenBurger());
        return meal;
    }

    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
        builder.beefCoCaMeal().showFood();
        builder.chickenPepsiMeal().showFood();
    }
}
