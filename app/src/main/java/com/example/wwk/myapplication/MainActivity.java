package com.example.wwk.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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

import org.w3c.dom.Text;

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
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //查询openClassTable表中所有的数据
                Cursor cursor = db.query("openClassTable", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        //遍历cursor对象，取出数据并打印
                        Integer 年级 = cursor.getInt(cursor.getColumnIndex("年级"));
                        String 专业 = cursor.getString(cursor.getColumnIndex("专业"));
                        Integer 专业人数 = cursor.getInt(cursor.getColumnIndex("专业人数"));
                        String 课程名称 = cursor.getString(cursor.getColumnIndex("课程名称"));
                        String 选修类型 = cursor.getString(cursor.getColumnIndex("选修类型"));
                        Integer 学分 = cursor.getInt(cursor.getColumnIndex("学分"));
                        Integer 学时 = cursor.getInt(cursor.getColumnIndex("学时"));
                        Integer 实验学时 = cursor.getInt(cursor.getColumnIndex("实验学时"));
                        Integer 上机学时 = cursor.getInt(cursor.getColumnIndex("上机学时"));
                        String 起讫周序 = cursor.getString(cursor.getColumnIndex("起讫周序"));
                        String 任课教师 = cursor.getString(cursor.getColumnIndex("任课教师"));
                        String 备注 = cursor.getString(cursor.getColumnIndex("备注"));
                        Log.d("MainActivity","年级" + 年级);
                        Log.d("MainActivity", "专业" + 专业);
                        Log.d("MainActivity","专业人数" + 专业人数);
                        Log.d("MainActivity","课程名称" + 课程名称);
                        Log.d("MainActivity","选修类型" + 选修类型);
                        Log.d("MainActivity","学分" + 学分);
                        Log.d("MainActivity","学时" + 学时);
                        Log.d("MainActivity","实验学时" + 实验学时);
                        Log.d("MainActivity","上机学时" + 上机学时);
                        Log.d("MainActivity","起讫周序" + 起讫周序);
                        Log.d("MainActivity","任课教师" + 任课教师);
                        Log.d("MainActivity","备注" + 备注);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }


}
