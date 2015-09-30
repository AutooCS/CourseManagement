package com.example.wwk.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by wwk on 2015/9/30.
 */

public class queryDB {
    String[] cols = {"年级", "专业", "专业人数", "课程名称", "选修类型", "学分", "学时",
            "实验学时", "上机学时", "起讫周序", "任课教师", "备注"};
    int i, j = 0;
    String id;
    Bundle bundle = new Bundle();

    public Bundle queryDB(Context context) {
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(context, "ExcelDB.db", null, 3);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //查询的语法，参数1为表名；参数2为表中的列名；参数3为要查询的列名；参数4为对应列的值；该函数返回的是一个游标
        Cursor cursor = db.query("openClassTable", null, null, null, null, null, null);
        while(cursor.moveToNext()) {
            for (i = 0; i < cols.length; i++) {
                id = "cell" + j + i;
                bundle.putString(id, cursor.getString(cursor.getColumnIndex(cols[i])));
//                Log.d(id, cursor.getString(cursor.getColumnIndex(cols[i])));
            }
            j++;
        }
        bundle.putInt("rows", j);
        bundle.putInt("cols", i);
        cursor.close();
        return bundle;
    }
}