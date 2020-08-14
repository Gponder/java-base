package com.gponder.structure;

import java.math.BigDecimal;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/8/14 8:58
 *
 * IEEE754标准 1985
 * 用二进制表示十进制数有限位数小数时可能是无限位数小数所以只能截取一定位数所以会丢失精度 精度不同误差也不一样所以有了IEEE754标准
 * java 中可以用 {@link BigDecimal}来进行计算
 */
public class FloatTrait {
    public static void main(String[] args) {
        System.out.println(0.1+0.2);
        System.out.println((0.1+0.2)==0.3);//Condition '(0.1+0.2)==0.3' is always 'false'
        System.out.println(0.1+0.7);
        System.out.println(0.2+0.4);

        System.out.println(0.3-0.2);
        System.out.println(1.5-1.2);

        System.out.println(0.8 * 3);
        System.out.println(19.9 * 100);

        System.out.println(0.3 / 0.1);
        System.out.println(0.69 / 10);

        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)).floatValue() == new BigDecimal(0.3).floatValue());
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)).floatValue() == 0.3);
    }
}
