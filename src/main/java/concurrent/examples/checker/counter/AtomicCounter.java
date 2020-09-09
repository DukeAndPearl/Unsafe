package concurrent.examples.checker.counter;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter implements Counter {

    AtomicLong counter = new AtomicLong(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public long getCounter() {
        return counter.get();
    }

}
