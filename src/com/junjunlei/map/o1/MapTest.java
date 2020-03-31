package com.junjunlei.map.o1;

import org.junit.Test;

import java.util.*;

/**
 * 一、Map的实现类的结构：
 * |----Map:双列数据，存储key-value对的数据   ---类似于高中的函数：y = f(x)
 * |----HashMap:作为Map的主要实现类；线程不安全的，效率高；存储null的key和value
 * |----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 * 原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 * 对于频繁的遍历操作，此类执行效率高于HashMap。
 * |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序
 * 底层使用红黑树
 * |----Hashtable:作为古老的实现类；线程安全的，效率低；不能存储null的key和value
 * |----Properties:常用来处理配置文件。key和value都是String类型
 * <p>
 * <p>
 * HashMap的底层：数组+链表  （jdk7及之前）
 * 数组+链表+红黑树 （jdk 8）
 * <p>
 * <p>
 * 面试题：
 * 1. HashMap的底层实现原理？
 * 2. HashMap 和 Hashtable的异同？
 * 3. CurrentHashMap 与 Hashtable的异同？
 * <p>
 * <p>
 * 二、Map结构的理解：
 * Map中的key:无序的、不可重复的，使用Set存储所有的key  ---> key所在的类要重写equals()和hashCode() （以HashMap为例）
 * Map中的value:无序的、可重复的，使用Collection存储所有的value --->value所在的类要重写equals()
 * 一个键值对：key-value构成了一个Entry对象。
 * Map中的entry:无序的、不可重复的，使用Set存储所有的entry
 *
 * @author junjun.lei
 * @create 2020-03-31 15:33
 */
public class MapTest {

    private static Map<String, String> map;

    static {
        map = new HashMap<>(16);
        map.put("及时雨", "宋江");
        map.put("玉麒麟", "卢俊义");
        map.put("智多星", "吴用");
        map.put("入云龙", "公孙胜");
        map.put("大刀", "关胜");
        map.put("豹子头", "林冲");
        map.put("霹雳火", "秦明");
    }

    @Test
    public void test01() {
        //map中的key  使用Set存储       判断map的两个key是不是同一个，必须重写
        Set<String> set = map.keySet();
        //map中的value  使用Collection存储
        Collection<String> collection = map.values();
    }

    /**
     * map的遍历方式
     */
    @Test
    public void test02() {
        //jdk 1.8 lambda表达式遍历
        map.forEach((k, v) -> {
            System.out.println("绰号:" + k + "  " + "本名：" + v);
        });

        System.out.println("======================================");

        //增强for遍历 map的key的集合 map.keySet()  根据key获取value
        Set<String> set = map.keySet();
        for (String str : set) {
            System.out.println("绰号:" + str + "  " + "本名：" + map.get(str));
        }

        System.out.println("======================================");

        //遍历Map.Entry （一个（key-values）为一个entry）
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            entry.getKey();
            System.out.println("绰号:"+entry.getKey()+"  "+"本名："+entry.getValue());
        }

        System.out.println("======================================");

        //key集合迭代器
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = map.get(key);
            System.out.println("绰号:"+key+"  "+"本名："+value);
        }

        System.out.println("======================================");

        //Map.Entry迭代器
        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, String> next = iterator1.next();
            String key = next.getKey();
            String value = next.getValue();
            System.out.println("绰号:"+key+"  "+"本名："+value);
        }
    }
}
