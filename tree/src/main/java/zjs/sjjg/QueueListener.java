package zjs.sjjg;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueListener {
    private BlockingQueue<Object> queue = new LinkedBlockingQueue<>();

    public void startListening() {
        Thread listenerThread = new Thread(() -> {
            try {
                while (true) {
                    Object element = queue.take(); // 从队列中取出元素，如果队列为空则阻塞等待
                    // 执行相应的处理逻辑
                    System.out.println("Processing element: " + element);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        listenerThread.start();
    }

    public void addToQueue(Object element) {
        queue.add(element); // 将元素加入队列
    }

    public static void main(String[] args) {
        QueueListener listener = new QueueListener();
        listener.startListening();
        // 模拟向队列中添加元素
        for (int i = 0; i < 10; i++) {
            listener.addToQueue("Element " + i);
        }
    }
}
