import com.marco.designPattern.abstractFactory.*;



import com.marco.designPattern.strategy.*;
import com.marco.designPattern.singleton.*;
import com.marco.enumTest;
import com.marco.file.AppendToFile;
import com.marco.file.ReadFromFile;
import com.marco.serializeTest.MyLog;

import java.io.*;

public class Main implements Runnable{
    public void run(){

    }


    public static void main(String[] args) {
//        enumTest e = new enumTest();
//        e.test();
        MyLog myLog = new MyLog("syw","11");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/sunwenbin/Downloads/javatest/src/com/marco/serializeTest/mylog"));
            objectOutputStream.writeObject(myLog);
            objectOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/sunwenbin/Downloads/javatest/src/com/marco/serializeTest/mylog"));
            MyLog myLog1 = (MyLog) objectInputStream.readObject();
            System.out.println(myLog1);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
