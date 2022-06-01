package com.example.demo.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auth Jacob
 * @date 2021/8/19 14:37
 */
public class RegexMatches {
    public static void main(String[] args) {
        String str = "3|李思思04847";
        String pattern = "(3\\|\\s*)(.*7)";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }
}
