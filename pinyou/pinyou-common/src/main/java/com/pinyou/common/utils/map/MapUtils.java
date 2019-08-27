package com.pinyou.common.utils.map;

import java.util.*;

/**
 * @ClassName MapUtils
 * @Discription TODO
 * @Author zhidong.li
 * @Date 2019年08月27日 10:03
 */
public class MapUtils {

    /**
     * 根据key排序
     * @param map
     * @return
     */
    public static Map<String, String> sortByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> resultMap = new TreeMap<>(String::compareTo);
        resultMap.putAll(map);
        return resultMap;
    }

    /**
     * 根据value排序
     * @param map
     * @return
     */
    public static Map<String, String> sortByValue(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        List<Map.Entry<String, String>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList,Comparator.comparing(Map.Entry<String,String>::getValue));

        Iterator<Map.Entry<String, String>> iter = entryList.iterator();
        Map.Entry<String, String> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("a","java");
        map.put("c","javascript");
        map.put("b","c++");
        map.put("d","ios");

        Map<String,String> key = MapUtils.sortByKey(map);

//        key.keySet().forEach((key1) ->{
//            System.out.println("map key:"+ key1 +",map value:"+key.get(key1));
//    });

        key.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() +":"+entry.getValue());
        });

        key.forEach((k,v) ->{
            System.out.println(k+":"+v);
        });
    }
}
