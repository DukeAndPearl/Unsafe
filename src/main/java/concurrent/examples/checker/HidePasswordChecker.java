package concurrent.examples.checker;

import java.lang.reflect.Field;

public class HidePasswordChecker extends Checker {

    @Override
    public void check() {
        String password = new String("l00k@myHor$e");
        String fake = new String(password.replaceAll(".", "?"));

        printer.print("password:");
        printer.print(password);
        printer.print("fake password:");
        printer.print(fake);

        Field stringValue;
        try {
            stringValue = String.class.getDeclaredField("value");
            stringValue.setAccessible(true);
            char[] mem = (char[])stringValue.get(password);
            for (int i = 0; i < mem.length; i++) {
                mem[i] = '?';
            }
            printer.print("password deleted:");
            printer.print(password);
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

}
