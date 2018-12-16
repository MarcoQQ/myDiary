package com.marco.file;
import java.util.HashMap;
import java.io.*;

public class ReadFromFile {

    public static void readFileByBytes(String fileName){
        File file = new File(fileName);
        InputStream in = null;
        try{
            System.out.println("一次读一个字节");
            in = new FileInputStream(file);
            int tempbyte;
            while((tempbyte = in.read()) != -1){
                System.out.write(tempbyte);
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
        try{
            System.out.println("一次读多个字节");
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(file);
            ReadFromFile.showAvailableBytes(in);
            while((byteread = in.read(tempbytes)) != -1){
                System.out.write(tempbytes, 0, byteread);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(in != null){
                try{
                    in.close();
                }catch (Exception e){

                }
            }
        }
    }

    public static void readFileByChars(String fileName){
        File file = new File(fileName);
        Reader reader = null;
        try{
            System.out.println("以字符为单位读取文件内容，一次读一个字节");
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while((tempchar = reader.read()) != -1){
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            System.out.println("以字符为单位读取文件内容，一次读多个字节");
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            while ((charread = reader.read(tempchars)) != -1) {
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }
            }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }


    }

    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in){
        try{
            System.out.println("当前字节输入流中的字节数为：" + in.available());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
