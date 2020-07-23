package com.gponder.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/23 14:59
 */
public class AnnotationMain {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Target target = new Target();
        System.out.println(target.toString());
        Method[] ms = target.getClass().getMethods();
        for (Method method:ms){
            Annotation[] annos = method.getAnnotations();
            for (Annotation annotation:annos){
                if (annotation instanceof  SimpleAnnotation){
                    System.out.println(method.getName());
                    System.out.println(method.invoke(target));

                }
            }
        }
    }

    static class Target{
        @SimpleAnnotation
        @Override
        public String toString() {
            return super.toString();
        }
    }
}
