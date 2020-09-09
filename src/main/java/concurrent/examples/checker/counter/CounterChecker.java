package concurrent.examples.checker.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import concurrent.examples.checker.Checker;

public class CounterChecker extends Checker {

    @Override
    public void check() {
        test(new StupidCounter());
        test(new SyncCounter());
        test(new LockCounter());
        test(new AtomicCounter());
        try {
            test(new CASCounter());
        } catch (Exception e) {
            printer.print(e);
        }

    }

    private void test(Counter counter) {
        int NUM_OF_THREADS = 1000;
        int NUM_OF_INCREMENTS = 100000;
        ExecutorService service = Executors.newFixedThreadPool(NUM_OF_THREADS);
        long before = System.currentTimeMillis();
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            service.submit(new CounterClient(counter, NUM_OF_INCREMENTS));
        }
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long after = System.currentTimeMillis();
        printer.print(counter.getClass().getName());
        printer.print("Counter result: " + counter.getCounter());
        printer.print("Time passed in ms:" + (after - before));
    }

}
