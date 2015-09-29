package com.example.wwk.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {
    private MyDatabaseHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据库
        dbHelper = new MyDatabaseHelper(this, "ExcelDB.db", null, 3);
        dbHelper.getWritableDatabase();

        Button but5 = (Button) findViewById(R.id.but5);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alert=new AlertDialog.Builder(MainActivity.this).create();
                alert.setTitle("课程详情");
                String s[]={"2012","计算机科学与技术","87"," Internet技术与协议分析实验",
                "实践选修","1","24","",""};
                alert.setMessage("年级:"+s[0]+'\n'
                +"专业:"+s[1]+'\n'
                +"专业人数："+s[2]+'\n');
                alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alert.cancel();
                    }
                });
                alert.show();
            }
        });



    }


}
