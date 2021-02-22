import org.apache.log4j.Logger;

public class CustomRunnableThread implements Runnable {
    private static final Logger logger = Logger.getLogger(CustomRunnableThread.class);
    private final Counter counter;

    public CustomRunnableThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            logger.info("Runnable " + counter.increment());
        }
    }
}
