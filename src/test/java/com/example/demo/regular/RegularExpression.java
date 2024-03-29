package com.example.demo.regular;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegularExpression
 * @Description 正则表达式测试类
 * @Author Jacob
 * @Version 1.0
 * @since 2020/6/4 11:26
 **/
public class RegularExpression {

    public static void main(String[] args) {
        String abc = "aa文字e79fa5e98193e78988e69d83313333656566331bb哈哈cc测试dx，测试字符串aa1234bb";
        System.out.println(abc.replaceFirst("aa.*?bb", "cc成功dd"));
        System.out.println(abc.replaceAll("(aa).*?(bb)", "$1成功$2"));
        System.out.println(abc.replaceAll("([a-z]+).*?([a-z]+)", "$1成功$2"));
        System.out.println(abc.replaceAll("[a-z]+.*?[a-z]+", "|成功|"));
        System.out.println(abc.replaceAll("([a-z]+)(.*?)([a-z]+)", "($1|$2|$3)"));
        System.out.println(abc);

        System.out.println("good idea, nice try.".replaceAll("good(.*)|(.*)nice(.*)", "B$1$2A$2"));
        System.out.println("|test=" + "good idea, nice try.".matches(".*nice.*"));
        System.out.println("#AAA".matches("#[^0-9a-fA-F]{3}|#[0-9a-fA-F]{6}"));
        System.out.println("hello".replaceAll("^|$", "#"));
        //千位表示法
        System.out.println("123456789.43423".replaceAll("(?!^)(?=(\\d{3})+\\.)", ","));
        System.out.println("[JS] Lesson_01.mp4".replaceAll("\\b", "#"));

        String reg = "^((0{0,2}\\d|0?[1-9]\\d|1\\d{2}|2[0-5]{2})\\.){3}(0{0,2}\\d|0?[1-9]\\d|1\\d{2}|2[0-5]{2})$";
        System.out.println("253.0.0.251".matches(reg));

        System.out.println("\n".matches("."));


        /**
         * 测试从正则表达式中，获取匹配到的值
         */
        String ccc = "aa文字e79fa5e98193e78988e69d83313333656566331bb哈哈cc测试dx，测试字符串aa1234bb";
        System.out.println(ccc.replaceAll("([a-z]+)(.*?)([a-z]+)", "($1|$2|$3)"));

        System.out.println(JSONObject.toJSONString(getMachers("([a-z]+)(.*?)([a-z]+)", ccc,3)));
        String text = "云南省曲靖市沾益区金龙街道金龙社区居民委员会后圩村219号";
        String reg2 = "(^.*?省)|(.*?市)|(.*)";
        System.out.println(JSONObject.toJSONString(getMachers(reg2, text)));

        System.out.println(JSONObject.toJSONString(getMachers("([a-z]+)(\\d+)", "ads1212adf123")));
        System.out.println(JSONArray.toJSONString(getMachers("(.*?\\|)|(.*?7)", "3 | 李思思04847")));
        System.out.println(JSONArray.toJSONString(getMachers("windows(?=95)", "windows95")));
        test("^[a-z]", "a");
    }

    private static void test(String reg, String test) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(test);
        System.out.println("matcher result=" + matcher.matches());
    }

    private static List<String> getMachers(String reg, String test, int... index){
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(test);
//        System.out.println("matcher result=" + matcher.matches());
        List<String> list = new ArrayList<>();
        int group = 0;
        if (index.length > 0)
            group = index[0];
        while (matcher.find()){
            String findStr = matcher.group(group);
            if (StringUtils.isBlank(findStr)) {
                continue;
            }
            list.add(findStr);
        }
        return list;
    }

}
