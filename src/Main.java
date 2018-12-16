import com.marco.designPattern.abstractFactory.*;



import com.marco.designPattern.strategy.*;
import com.marco.designPattern.singleton.*;
import com.marco.file.AppendToFile;
import com.marco.file.ReadFromFile;

public class Main implements Runnable{
    public void run(){

    }


    public static void main(String[] args) {
        String fileName = "/Users/sunwenbin/Desktop/笔记/线程";
        AppendToFile.append(fileName,"2018年底");



    }
}
