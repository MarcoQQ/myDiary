package com.marco.designPattern.singleton;

//懒汉
public class Singleton {
    private static Singleton singleton;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton != null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
