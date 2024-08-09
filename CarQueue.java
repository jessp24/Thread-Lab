import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
    private Queue<Integer> queue;
    private Random random;

    public CarQueue() {
        queue = new LinkedList<>();
        random = new Random();

        for (int i = 0; i < 7; i++) {
            queue.add(random.nextInt(4));
        }
    }

    public void addToQueue() {
        class AddRandom implements Runnable {
            @Override
            public void run() {
                while (true) {
                    queue.add(random.nextInt(4));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        new Thread(new AddRandom()).start();
    }
    public Integer deleteQueue() {
        return queue.remove();
    }
    
}
