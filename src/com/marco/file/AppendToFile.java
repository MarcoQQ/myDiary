package com.marco.file;

import java.io.FileWriter;

public class AppendToFile {
    //字符写
    public static void append(String fileName, String context){
        try{
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(context);
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
