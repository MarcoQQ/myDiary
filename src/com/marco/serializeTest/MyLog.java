package com.marco.serializeTest;
import java.util.Date;

public class MyLog implements java.io.Serializable{
    private String uid;
    private transient String pwd;
    private Date log_date = new Date();

    public MyLog(String name, String password){
        uid = name;
        pwd = password;
    }

    @Override
    public String toString() {
        String password;
        if(pwd == null){
            password = "NOT SET";
        }else{
            password = pwd;
        }
        return "用户名" + uid + "\n" + "密码" + password + "\n" + "日期" + log_date.toString();

    }
}
