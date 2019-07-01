package com.xjs.mid.my627;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
       private  EditText user;
       private  EditText password;
       private  CheckBox checkBox;
       private  Button button;
       private  static final String tag="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       user=findViewById(R.id.user);
           password=findViewById(R.id.password);
        checkBox=findViewById(R.id.ck);
        button=findViewById(R.id.login);
        button.setOnClickListener(this);
        //回显数据
      Map<String,String>  userInfo=Utils.getUserInfo();
        if (userInfo!=null){
            user.setText(userInfo.get("number"));
            password.setText(userInfo.get("password"));
        }


    }
    public void onClick(View view){
              //1.取出密码
        String number=user.getText().toString();
        String pass=password.getText().toString();
           //判断是否输入。否就return
        if (TextUtils.isEmpty(number) || TextUtils.isEmpty(pass)){
            //弹出吐司
            Toast.makeText(this,"请正确输入",Toast.LENGTH_LONG).show();
              return;
        }
        //2判断记住密码是否被选中，如果被选中，存起来
        if (checkBox.isChecked()){
            //当前需要记住密码
            Log.i(tag,"记住密1码ffff2: " + user +","+ password);

            boolean    isSuccess  =Utils.saveUserInfo(number,pass);
            if (isSuccess){
                Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,"保存失败",Toast.LENGTH_LONG).show();
            }
        }
        //3.登陆成功
        Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();
    }
}