package com.later.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 不使用java8新特性方式的传统排序方法
 * Created by liqiliang <liqiliang@baibu.la> on 2016/9/30.
 */
public class Java7SortMapByKey {
    public static void main(String[] args) {

        Map<String, String> unsortMap = new HashMap<String, String>();
        unsortMap.put("Z", "z");
        unsortMap.put("B", "b");
        unsortMap.put("A", "a");
        unsortMap.put("C", "c");
        unsortMap.put("D", "d");
        unsortMap.put("E", "e");
        unsortMap.put("Y", "y");
        unsortMap.put("N", "n");
        unsortMap.put("J", "j");
        unsortMap.put("M", "m");
        unsortMap.put("F", "f");

        System.out.println("Unsort Map......");
        printMap(unsortMap);

        System.out.println("\nSorted Map......By Key");
        Map<String, String> treeMap = new TreeMap<String, String>(unsortMap);
        printMap(treeMap);

    }

    //pretty print a map
    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + " Value : " + entry.getValue());
        }
    }
}
