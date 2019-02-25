package com.marco.threadStudy;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class MyFuture {
    public static void main(String args[]){
        testFuture();
    }

    public static void testFuture(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                sleep(1000);
                return 1;
            }
        });
        service.shutdown();

        try{
            System.out.println(future.get(100, TimeUnit.MILLISECONDS));
        }catch (Exception e){
            e.printStackTrace();
        }
     }
}
