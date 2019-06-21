package com.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 生于忧患，死于安逸
 * 死于听天由命和漫不经心
 *
 *
 */
public class TypeDemo {

    private List<String> list;

    private Map<String, Integer> map;

    public static void main(String[] args) {
        //Type体系
        //五大类型
        //1.参数化类型ParameterizedType
        //表示的是参数化类型也就是泛型
        //2.Class它是Type接口的直接实现,java中每一.class文件运行时都
        //对应着一个Class对象
        //3.GenericArrayType:泛型数组类型
        //4.TypeVariable:泛型的类型变量 注意：泛型变量可以声明在Class、Constructor、Method上面
        //5.WildcardType:通配符泛型,他表示的是某种Type而不是具体哪一种Type
        try {
            Field listField = TypeDemo.class.getDeclaredField("list");
            Type type = listField.getGenericType();
            System.out.println(type.getTypeName());

            Field mapField = TypeDemo.class.getDeclaredField("map");
            Type mapType = mapField.getGenericType();
            System.out.println(mapType.getTypeName());

            if (mapType instanceof ParameterizedType){
                ParameterizedType pt = ParameterizedType.class.cast(mapType);
                Type [] types = pt.getActualTypeArguments();
                System.out.println(Arrays.toString(types));
                for (Type t: types){
                    System.out.println(t.getTypeName());
                    System.out.println(Class.class.isInstance(t.getClass()));
                }

                Type ownerType = pt.getOwnerType();
                System.out.println("ownerType:" + ownerType);

                Type rawType = pt.getRawType();
                System.out.println("rawType:" + rawType.getTypeName());
            }

            //GenericDeclaration:表示声明类型变量的所有实体的公共接口,也就是说
            //该接口定义了哪些地方可以定义泛型变量
            //GenericDeclaration:三个实现分别为Class、Constructor、Method
            //所以说TypeVariable只能声明在Class,Constructor、Method上面



        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
