package concurrent.examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import sun.misc.Unsafe;

public class FastSerialization extends Checker {

    @Override
    public void check() {
        Class<? extends Unsafe> cls = unsafe.getClass();
        Method[] methods = cls.getMethods();
        printer.print("");
        printer.print(methods);
        Field[] declaredFields = cls.getDeclaredFields();
        printer.print("");
        printer.print(declaredFields);
        Constructor<?>[] constructors = cls.getConstructors();
        printer.print("");
        printer.print(constructors);
    }

}
