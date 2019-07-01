package com.xjs.mid.my627;

import android.text.TextUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//保存用户信息
public class Utils {
    public  static boolean saveUserInfo(String user,String password){
                        String path="/data/data/com.xjs.mid.my627/FFF.txt";
        try  {
            FileOutputStream fos = new FileOutputStream(path);
            //密码使用 user##pass 55##66
                   String data=user+"##"+password;
                   fos.write(data.getBytes());
                   fos.flush();
                   fos.close();
                   return  true;
        }catch (Exception e){


        }

        return  false;
    }

//获取数据
    public static Map<String,String> getUserInfo(){
        String path="/data/data/com.xjs.mid.my627/FFF.txt";

        try  {
            FileInputStream fos = new FileInputStream(path);
            //字符流对象
            BufferedReader reader=new BufferedReader(new InputStreamReader(fos));
            String text=reader.readLine();
            if (!TextUtils.isEmpty(text)){
                String[] sp=text.split("##");

            Map<String,String>  userInfoMap=new HashMap<String, String>();
            userInfoMap.put("number",sp[0]);
            userInfoMap.put("password",sp[1]);
            return  userInfoMap;

            }
        }catch (Exception e){
e.printStackTrace();
        }
        return  null;
    }

}
