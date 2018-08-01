package app.xupt.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        String path = "app.xupt.Reflect.User";
        Class aClass = Class.forName(path);

        // 获取类的信息
        System.out.println("包名+类名-------" + aClass.getName());
        System.out.println("包名------------" + aClass.getSimpleName());
        System.out.println("toString--------" + aClass);


        // 获取 Field 属性

        System.out.println("-------所有属性------");
        Field[] Fields = aClass.getDeclaredFields();
        for (Field f :
                Fields
                ) {
            System.out.println(f);
        }
        // Field aField = aClass.getField("age");   无法访问私有属性
        Field aField = aClass.getDeclaredField("age");
        System.out.println("age属性-------" + aField);


        // 获取构造器 Constructor

        System.out.println("---------所有构造器-------");
        for (Constructor con :
                aClass.getConstructors()
                ) {
            System.out.println(con);
        }
        System.out.println("无参构造--------" + aClass.getConstructor());   // 获取无参构造器
        System.out.println("有参构造--------" + aClass.getConstructor(int.class, int.class, String.class));   // 获取有参构造器

        // 获取方法 Method
        System.out.println("---------所有方法-------");
        for (Method m :
                aClass.getDeclaredMethods()  // aClass.getdMethods() 获取所有方法，包括继承的
                ) {
            System.out.println(m);
        }
        System.out.println("获取无参方法--------" + aClass.getMethod("setUname"));
        System.out.println("获取带参方法--------" + aClass.getMethod("setUname", String.class));

    }
}
