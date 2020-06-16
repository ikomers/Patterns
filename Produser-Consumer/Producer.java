package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            ShareItem item = new ShareItem("ShareItem-" + i, i);
            queue.offer(item);
            System.out.format("Элемент 'ShareItem-%d' добавлен" + "\n", i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.format(e.getMessage());
            }
            if (queue.hasWaitingConsumer()) {
                System.out.format("Consumer в ожидании!" + "\n");
            }
        }
    }

    public void offer() {

    }
}