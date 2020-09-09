package concurrent.examples.checker;

import java.lang.reflect.Field;

import concurrent.utils.Printer;
import sun.misc.Unsafe;

public abstract class Checker {

    public abstract void check();

    protected static Printer printer;
    protected static Unsafe unsafe;

    static {
        printer = new Printer();
        initUnsafe();

    }

    private static void initUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe)f.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static long normalize(int value) {
        if (value >= 0)
            return value;
        return (~0L >>> 32) & value;
    }

}
