package com.marco.threadStudy;



public class MySychronized {
    private static Object obj = new Object();

    public static void testSynchronized1(int threadNumber){
        synchronized (obj){
            try{
                for(int i = 0; i < 10; ++i){
                    Thread.sleep(1000);
                    System.out.println(String.format("T1:%d:%d", threadNumber, i));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void testSynchronized2(int threadNumber){
        synchronized (obj){
            try{
                for(int i = 0; i < 10; ++i){
                    Thread.sleep(1000);
                    System.out.println(String.format("T2:%d:%d", threadNumber, i));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void testSynchronized(){
        for(int i = 0; i < 10; i++){
            final int threadNumber = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testSynchronized1(threadNumber);
                    testSynchronized2(threadNumber);
                }
            }).start();
        }
    }

    public static void main(String[] arg){
        testSynchronized();
    }
}
