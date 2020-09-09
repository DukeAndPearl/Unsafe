package concurrent.examples.checker.counter;

public class StupidCounter implements Counter {

    private long num = 0;

    public void increment() {
        num++;
    }

    public long getCounter() {
        return num;
    }

}
