import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.ArrayList;
import java.util.List;

public class ConsumerThread implements Runnable{
    public void run() {
        ConsumerTest consumerTest = new ConsumerTest();
        List<String> topicList = new ArrayList<String>();
        String topic = "test_20210522";
        System.out.println("Thread "+ Thread.currentThread() +" starts consume kafka from topic: " + topic);
        topicList.add(topic);
        consumerTest.consume(topicList);
        while(true) {
            ConsumerRecords<String, String> records = consumerTest.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(Thread.currentThread() + " Partition(k,v): " + record.partition() + "(" + record.key() + ", " + record.value() + ")");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
