package concurrent.examples.checker.counter;

public class CounterClient implements Runnable {

    private Counter c;
    private int num;

    public CounterClient(Counter c, int num) {
        this.c = c;
        this.num = num;
    }

    public void run() {
        for (int i = 0; i < num; i++) {
            c.increment();
        }
    }

}
