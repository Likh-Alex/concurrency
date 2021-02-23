import org.apache.log4j.Logger;

public class CustomRunnableThread implements Runnable {
    private static final Logger logger = Logger.getLogger(CustomRunnableThread.class);
    private final Counter counter;

    public CustomRunnableThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            logger.info("Runnable " + counter.increment());
        }
    }
}
