package app.xupt.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ClassPrinter {
    public static final String CRLF = "\r\n";

    public static void main(String[] args) throws ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        String clazz = in.nextLine();
        Class aClass = Class.forName(clazz);
        Class superClass = aClass.getSuperclass();
        String Mod = Modifier.toString(aClass.getModifiers());
        if (Mod.length() > 0) System.out.print(Mod + " ");
        System.out.print("class " + aClass.getSimpleName() + " ");
        if (superClass != null && superClass != Object.class) System.out.print("extends " + superClass.getSimpleName());
        System.out.print(CRLF + "{" + CRLF);

        //  Field Printer

        Field[] fields = aClass.getDeclaredFields();
        if (fields.length > 0) {
            for (Field f : fields
                    ) {
                System.out.print("\t" + Modifier.toString(f.getModifiers()) + " ");
                System.out.print(f.getType().toString() + " " + f.getName() + ";" + CRLF);
            }
            System.out.println();
        }

        // Constructor Printer

        Constructor[] constructors = aClass.getConstructors();
        if (constructors.length > 0) {
            for (Constructor c : constructors
                    ) {
                System.out.print("\t");
                System.out.print(Modifier.toString(c.getModifiers()) + " ");
                System.out.print(c.getName());
                System.out.print("(");
                if (c.getParameterTypes().length > 0) {
                    int i = 0;
                    for (Class t : c.getParameterTypes()
                            ) {
                        if (i != 0) System.out.print(",");
                        System.out.print(t.getName());
                        i++;
                    }
                }
                System.out.print(");");
                System.out.println();
            }
        }

        //  Field Printer

        Method[] methods = aClass.getDeclaredMethods();
        if (methods.length > 0) {
            System.out.println();
            for (Method m : methods
                    ) {
                for (Constructor c : constructors
                        ) {
                    System.out.print("\t");
                    System.out.print(Modifier.toString(m.getModifiers()) + " ");
                    System.out.print(m.getName());
                    System.out.print("(");
                    if (m.getParameterTypes().length > 0) {
                        int i = 0;
                        for (Class t : m.getParameterTypes()
                                ) {
                            if (i != 0) System.out.print(",");
                            System.out.print(t.getName());
                            i++;
                        }
                    }
                    System.out.print(");");
                    System.out.println();
                }
            }
        }

        System.out.print("}");
    }
}
