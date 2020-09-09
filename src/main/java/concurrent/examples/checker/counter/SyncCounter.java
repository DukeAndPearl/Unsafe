package concurrent.examples.checker.counter;

public class SyncCounter implements Counter {

    private long num = 0;

    public synchronized void increment() {
        num++;
    }

    public long getCounter() {
        return num;
    }

}
