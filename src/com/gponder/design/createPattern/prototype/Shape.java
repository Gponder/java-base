package com.gponder.design.createPattern.prototype;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/4/9 18:32
 */
public abstract class Shape implements Cloneable{

    private String id;

    protected String type;

    public abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Shape clone(){
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
