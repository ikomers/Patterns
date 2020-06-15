package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

    }

    public void offer() {
        for (int i = 1; i < 10; i++) {
            System.out.format("Элемент 'ShareItem-%d' добавлен", i);
            String s = "ShareItem-" + i;
            queue.add(new ShareItem(s, i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.format(e.getMessage());
            }
        }
    }
}