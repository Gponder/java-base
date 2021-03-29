package com.gponder.character.j8.methodRreference;

public class FunctionRef {

    private String name;

    FunctionRef(String name){
        this.name=name;
    }

    public static void main(String[] args) {
        InterfaceExample com =  FunctionRef::new;
        FunctionRef bean = com.create("hello");
        System.out.println(bean.name);
    }

}
