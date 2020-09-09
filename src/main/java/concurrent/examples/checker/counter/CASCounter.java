package concurrent.examples.checker.counter;

import concurrent.examples.checker.Checker;

public class CASCounter extends Checker implements Counter {

    private volatile long counter = 0;
    private long offset;

    public CASCounter() throws Exception {
        offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
    }

    public void increment() {
        long before = counter;
        while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
            before = counter;
        }

    }

    public long getCounter() {
        return counter;
    }

    @Override
    public void check() {
        printer.print("Nothing to checker here.");
    }

}
