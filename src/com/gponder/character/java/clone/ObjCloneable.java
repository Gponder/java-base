package com.gponder.character.java.clone;

/**
 * Cloneable 接口中没有任何方法，但是实现它却可以扩展.clone()方法。类似接口还有Serializable
 *
 * 浅克隆  深克隆需要实现clone()方法递归实现clone()操作
 */
public class ObjCloneable implements Cloneable{

    private int i = 10000;
    private String s = "ObjCloneable";
    private Object o = new Object();

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ObjCloneable obj = new ObjCloneable();
        System.out.println(obj);
        System.out.println(obj.getO() == ((ObjCloneable)(obj.clone())).getO());
        System.out.println(obj.clone());
    }
}
