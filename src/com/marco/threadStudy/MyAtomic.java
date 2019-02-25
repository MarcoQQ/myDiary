package com.marco.threadStudy;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class MyAtomic {
    private static int counter;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void testWithAtomic() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(1000);
                        for (int i = 0; i < 10; i++) {
                            System.out.println(atomicInteger.incrementAndGet());

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }}).start();


        }
    }

    public static void testWithoutAtomic() {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(1000);
                        for (int i = 0; i < 10; i++) {
                            counter++;
                            System.out.println(counter);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }}).start();


        }
    }

    public static void main(String[] args){
//        testWithAtomic();
        testWithoutAtomic();
    }
}
