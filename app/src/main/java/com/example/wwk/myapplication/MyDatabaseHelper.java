package com.example.wwk.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by wwk on 2015/9/29.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_CLASS = "create table openClassTable ("
            + "年级 integer,"
            + "专业 text, "
            + "专业人数 integer, "
            + "课程名称 text primary key, "
            + "选修类型 text, "
            + "学分 integer, "
            + "学时 integer, "
            + "实验学时 integer, "
            + "上机学时 integer, "
            + "起讫周序 text, "
            + "任课教师 text, "
            + "备注 text)";


    private Context mContext;
    //第一个参数为该类本身；第二个参数为数据库的名字；第3个参数是用来设置游标对象的，这里一般设置为null；参数四是数据库的版本号。
    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context,name,factory,version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CLASS);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists openClassTable");
        onCreate(db);

    }

}


