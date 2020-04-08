package com.gponder.design.createPattern.factory;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/5 15:36
 * 工厂模式
 * 抽象工厂模式相当于把多个工厂再次进行工厂化
 */
public class ShapeFactory {

    /**
     * 其实枚举跟单例一样
     * 单例时在内部构建一个实力单例时在内部构建多个实例
     * 枚举的值相当于public的静态变量
     */
    enum ShapeType {
        CIRCLE(1),
        RECTANGLE(2),
        SQUARE(3);

        private int type;

        private ShapeType(int type) {
            this.type=type;
        }

        public int getType(){
            return type;
        }

        @Override
        public String toString() {
            return Integer.toString(type);
        }
    }

    public Shape getShape(ShapeType type){
        switch (type){
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            default:return null;
        }
    }

    public static void main(String[] args) {
        new ShapeFactory().getShape(ShapeType.CIRCLE);
    }
}
