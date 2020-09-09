package concurrent.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Printer {

    public void print(Object obj) {
        System.out.println(obj.toString());
    }

    public void print(String str) {
        System.out.println(str);
    }

    public void print(boolean bl) {
        System.out.println(bl);
    }

    public void print(Method[] methods) {
        for (Method m : methods) {
            m.setAccessible(true);
            System.out.print("Method Name:");
            System.out.println(m.getName());
            System.out.print("Value:");
            System.out.println(m.getDefaultValue());
            System.out.print("Modifier:");
            System.out.println(m.getModifiers());
        }
    }

    public void print(Field[] fields) {
        for (Field f : fields) {
            f.setAccessible(true);
            System.out.print("Field Name:");
            System.out.println(f.getName());
            System.out.print("Modifier:");
            System.out.println(f.getModifiers());
        }
    }

    public void print(Constructor<?>[] constructors) {
        for (Constructor<?> f : constructors) {
            f.setAccessible(true);
            System.out.print("Constructor Name:");
            System.out.println(f.getName());
            System.out.print("Modifier:");
            System.out.println(f.getModifiers());
        }
    }

}
