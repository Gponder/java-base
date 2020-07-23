package com.gponder.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/7/23 14:55
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface SimpleAnnotation {
}
