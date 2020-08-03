package com.example.demo.design.pattern.decorator;

import com.example.demo.design.pattern.decorator.beverages.DarkRoast;
import com.example.demo.design.pattern.decorator.beverages.Espresso;
import com.example.demo.design.pattern.decorator.beverages.HouseBlend;
import com.example.demo.design.pattern.decorator.condiments.Mocha;
import com.example.demo.design.pattern.decorator.condiments.Soy;
import com.example.demo.design.pattern.decorator.condiments.Whip;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.*;

/**
 * 装饰器模式测试类
 * @auth Jacob
 * @date 2020/8/3 13:42
 */
public class DecoratorTest {

    public static void main(String[] args) {
        //订一杯浓缩咖啡，不需要配料，打印描述和价钱
        Espresso espresso = new Espresso(CupSize.GRANDE);
        System.out.println(espresso);
        //订一个双摩卡奶泡深焙咖啡
        Beverage darkRoast = new DarkRoast(CupSize.GRANDE);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast);
        //订一个豆浆摩卡奶泡综合咖啡
        Beverage houseBlend = new HouseBlend(CupSize.VENTI);
        houseBlend = new Soy(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        System.out.println(houseBlend);
        System.out.println("===========lower case the start!");
        //测试IO字符转换成小写装饰器
        try (InputStream inputStream = new LowerCaseInputSteam(new BufferedInputStream(
                DecoratorTest.class.getClassLoader().getResourceAsStream("test.txt")
        ))) {
            int c;
            while ((c = inputStream.read()) > 0) {
                System.out.print((char)c);
            }
            System.out.println();
            System.out.println("===========lower case the end!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
