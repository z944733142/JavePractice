package app.xupt.Reflect;

public class Reflect {

    public static void main(String[] args) throws ClassNotFoundException {
        String path = "app.xupt.Reflect.User";

        Class clazz = Class.forName(path);
        System.out.println(clazz.hashCode());

        Class strClazz = String.class;
        Class strClazz2 = path.getClass();
        System.out.println(strClazz==strClazz2);

        Integer a = 5;
        Class IntCLass = Integer.class;
        Class IntClass2 = a.getClass();
        System.out.println(IntCLass == IntClass2);

        Class intCLass = int.class;

        // 返回的Class只和类型、维数有关。
        int[] ary01 = new int[10];
        int[] ary02 = new int[20];
        int[][] ary03 = new int[10][10];
        System.out.println(ary01.getClass().hashCode() + "  "
                + ary02.getClass().hashCode()+ "  "
                + ary03.getClass().hashCode());
    }
}
