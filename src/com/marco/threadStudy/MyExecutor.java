package com.marco.threadStudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class MyExecutor {
    public static void main(String[] args){
        testExecutor();
    }

    public static void testExecutor(){
//        ExecutorService service1 = Executors.newSingleThreadExecutor();
        ExecutorService service2 = Executors.newFixedThreadPool(2);
        service2.submit(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    try {
                        sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("Execute1 " + i);
                }
            }
        });
        service2.submit(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    try {
                        sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("Execute2 " + i);
                }
            }
        });

        service2.shutdown();
    }
}
