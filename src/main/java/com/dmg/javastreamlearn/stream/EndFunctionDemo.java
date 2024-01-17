package com.dmg.javastreamlearn.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName EndFunctionDemo
 * @Description stream 结尾方法示例
 * @author zhum
 * @date 2024/1/17 15:50
 */
public class EndFunctionDemo {
    public static void main(String[] args) {
        testCollect();

    }

    public static void testForEach(){
        List<String> list = CommonUtil.getStringList();
        list.forEach(System.out::println);
    }

    public static void testCount(){
        long count = CommonUtil.getStringList().stream().count();
        System.out.println(count);
    }

    //收集为数组
    public static void testToArray(){
        /*
            返回特定类型的数组
            IntFunction的泛型：指具体的数组类型
            apply的参数：返回的数组的长度
            apply的返回值：具体返回的数组
            @author zhum
            @date 2024/1/17 15:58
         */
        String[] array = CommonUtil.getStringList().stream().filter(name -> name.startsWith("张")).toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });

        for (String o : array) {
            System.out.println(o);
        }

    }

    /**
     * 收集流中的数据放到集合中 可以将数据转换为：List Set Map
     * @author zhum
     * @date 2024/1/17 16:02
     * @param
     * @return void
     */
    public static void testCollect(){
        Stream<String> stream = CommonUtil.getStringList().stream();

        //List<String> collect = stream.filter(name -> name.startsWith("张")).collect(Collectors.toList());
        //Set<String> collect1 = stream.collect(Collectors.toSet());
        Map<String, String> collect2 = stream.collect(Collectors.toMap(new Function<String, String>() {
            //形参是stream中的元素
            @Override
            public String apply(String s) {
                return s + UUID.randomUUID();
            }
        }, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        }));
        System.out.println(1);

    }
}
