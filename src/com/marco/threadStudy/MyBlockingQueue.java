package com.marco.threadStudy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;



class Producer implements Runnable{
    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    public void run(){
        try{
            for(int i = 0; i < 10; i++){
                Thread.sleep(1000);
                blockingQueue.add(String.format("message%d", i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

class Consumer implements Runnable{
    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    public void run(){
        try{
            while(true){
                System.out.println(Thread.currentThread().getName() + ":" + blockingQueue.take());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}


public class MyBlockingQueue {





    public static void main(String[] arg){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue), "consumer1").start();
        new Thread(new Consumer(blockingQueue), "consumer2").start();
    }


}
