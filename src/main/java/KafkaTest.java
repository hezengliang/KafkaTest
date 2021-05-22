import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KafkaTest {
    public static void main(String[] args) {
        // 测试线程数
        int threadNum = 4;
        System.out.println("We started " + threadNum + " thread(s) for test.");
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            executorService.submit(new ConsumerThread());
        }
    }
}
