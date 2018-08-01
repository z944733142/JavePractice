package app.xupt.Reflect;


import java.lang.reflect.*;


public class ReflectDemo04 {
    public static void main(String[] args) throws  ReflectiveOperationException {
        String path = "app.xupt.Reflect.User";
        Class<User> aClass = (Class<User>) Class.forName(path);

        // 反射构造对象

        User a = aClass.newInstance();  // 调用了User的无参构造方法
        a.getClass();
        System.out.println(a);

        // 构造器 Constructor
        Constructor<User> con = aClass.getConstructor();   // 无参构造
        Constructor<User> con2 = aClass.getDeclaredConstructor(int.class, int.class, String.class); //有参构造
        User a2 = con.newInstance();        // 创建对象  和 aClass.newInstance()一个效果
        User a3 = con2.newInstance(10001, 20, "zsg");  //创建对象
        System.out.println(a2.toString());
        System.out.println(a3.getId() + "  " + a3.getAge() + "  " + a3.getUname());

        // 方法 Method

        Method m = aClass.getMethod("setAge", int.class);
        m.invoke(a2,21);
        System.out.println(a2.getAge());

        // 属性 Field

        Field f = aClass.getDeclaredField("id");  // id 为私有不能直接访问
        f.setAccessible(true);   // 设置可直接访问
        f.set(a2, 300012);
        System.out.println(f.get(a2));
    }
}
