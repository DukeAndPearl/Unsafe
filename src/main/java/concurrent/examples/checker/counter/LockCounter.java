package concurrent.examples.checker.counter;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class LockCounter implements Counter {

    private long num = 0;
    private WriteLock lock = new ReentrantReadWriteLock().writeLock();

    public void increment() {
        lock.lock();
        num++;
        lock.unlock();
    }

    public long getCounter() {
        return num;
    }

}
