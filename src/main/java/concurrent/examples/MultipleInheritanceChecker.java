package concurrent.examples;

public class MultipleInheritanceChecker extends Checker {

    @Override
    public void check() {
        long intClassAddress = normalize(unsafe.getInt(new Integer(0), 4L));
        long strClassAddress = normalize(unsafe.getInt("", 4L));
        unsafe.putAddress(intClassAddress + 36, strClassAddress);

    }

}
