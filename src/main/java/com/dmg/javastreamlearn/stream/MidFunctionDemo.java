package com.dmg.javastreamlearn.stream;

import java.util.List;

/**
 * @ClassName MidFunctionDemo
 * @Description stream 中 中间方法的测试
 * @author zhum
 * @date 2024/1/17 15:47
 */
public class MidFunctionDemo {
    public static void main(String[] args) {

    }

    public static void testFilter(){
        List<String> list = CommonUtil.getStringList();
        /*
            1.找到以张开头的名字
            2.且长度为3
            3.放到新的集合并进行打印操作
            @author zhum
            @date 2024/1/17 15:25
         */

        list.stream().filter(name -> name.startsWith("张")).filter(name -> name.length() == 3).forEach(System.out::println);
    }

    public static void testLimit(){
        List<String> list = CommonUtil.getStringList();
        //只获取前几个
        list.stream().limit(2).forEach(System.out::println);
    }

    public static void testSkip(){
        List<String> list = CommonUtil.getStringList();
        //跳过前2个
        list.stream().skip(2).forEach(System.out::println);
    }

    public static void testDistinct(){
        List<String> list = CommonUtil.getStringList();
        //去重 如果是包装类，需要重写hashcode 和 equals 方法
        list.stream().distinct().forEach(System.out::println);
    }

    public static void testMap(){
        List<String> list = CommonUtil.getStringList();
        //转换类型  将string 转换为 Integer
        list.stream().map(name -> {
            return 1;
        }).forEach(System.out::println);
    }
}
