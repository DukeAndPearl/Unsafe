package concurrent.examples;

import java.lang.reflect.Field;

import concurrent.entity.Guard;

public class PrincipleSkipChecker extends Checker {

    @Override
    public void check() {
        Guard guard = new Guard();
        printer.print(guard.hasAccess());

        Field f;

        try {
            f = guard.getClass().getDeclaredField("ACCESS_ALLOWED");

            unsafe.putInt(guard, unsafe.objectFieldOffset(f), 777);

            printer.print(guard.hasAccess());

            unsafe.putInt(guard, 16 + unsafe.objectFieldOffset(f), 777);

            printer.print(guard.hasAccess());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

}
