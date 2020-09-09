package concurrent.examples.checker;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

import concurrent.entity.Book;
import concurrent.utils.Printer;

public class ShallowCopyChecker extends Checker {

    @Override
    public void check() {
        printer.print(sizeOf(new Printer()));
        printer.print(normalize(12));

        Book book = new Book("Copy Book");
        long address = toAddress(book);
        printer.print(address);

        Book newBook = (Book)fromAddress(address);
        printer.print(newBook.getName());

    }

    public static long sizeOfClassic(Object object) {
        int num = unsafe.getInt(object, 4L);
        long normalize = normalize(num);
        return unsafe.getAddress(normalize + 12L);
    }

    public static long sizeOf(Object o) {
        HashSet<Field> fields = new HashSet<Field>();
        Class<?> c = o.getClass();
        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }

        // get offset
        long maxSize = 0;
        for (Field f : fields) {
            long offset = unsafe.objectFieldOffset(f);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }

        return ((maxSize / 8) + 1) * 8; // padding
    }

    static Object shallowCopy(Object obj) {
        long size = sizeOf(obj);
        long start = toAddress(obj);
        long address = unsafe.allocateMemory(size);
        unsafe.copyMemory(start, address, size);
        return fromAddress(address);
    }

    static long toAddress(Object obj) {
        Object[] array = new Object[] {obj};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        return normalize(unsafe.getInt(array, baseOffset));
    }

    static Object fromAddress(long address) {
        Object[] array = new Object[] {null};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        unsafe.putLong(array, baseOffset, address);
        return array[0];
    }

}
