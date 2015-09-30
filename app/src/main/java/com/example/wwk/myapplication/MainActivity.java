package com.example.wwk.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private MyDatabaseHelper dbHelper;

    private List<Course> courseList = new ArrayList<Course>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据库
        dbHelper = new MyDatabaseHelper(this, "ExcelDB.db", null, 3);
        SQLiteDatabase db=dbHelper.getReadableDatabase();

        //查询数据库
        queryDB qdb=new queryDB();

       initCourses();
        courseAdapter adapter = new courseAdapter(MainActivity.this,
                R.layout.my_item, courseList);
        ListView listView = (ListView) findViewById(R.id.MyListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Course course1 = courseList.get(position);

                final AlertDialog alert=new AlertDialog.Builder(MainActivity.this).create();
                alert.setTitle("课程详情");

                String s[]={"2012","计算机科学与技术","87"," Internet技术与协议分析实验",
                "实践选修","1","24","",""};
                alert.setMessage("年级:"+s[0]+'\n'
                +"专业:"+s[1]+'\n'
                +"专业人数："+s[2]+'\n');

                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alert.cancel();
                    }
                });
                alert.setButton(DialogInterface.BUTTON_POSITIVE, "选择", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "未完成待续",
                                Toast.LENGTH_SHORT).show();
                        alert.cancel();
                    }
                });
                alert.show();
            }

        });
    }

    private void initCourses() {
//       Course apple = new Course("Apple","w");
//        courseList.add(apple);
//        Course banana = new Course("Banana","s" );
//        courseList.add(banana);


        Bundle bundle =  new queryDB().queryDB(this);

        int rows=bundle.getInt("rows");
        int cols = bundle.getInt("cols");
        int i;
        for(i=0;i<rows;i++) {
            String tmp = "cell" + i;
            Course cell = new Course(bundle.getString(tmp + 3), "未选");
            courseList.add(cell);
        }




//            List<Childs> child1 = new ArrayList<Childs>();
//            Childs child1V = new Childs();
//            child1V.setCourseName(bundle.getString(s1+3));
//            child1V.setZhuanYe(bundle.getString(s1+1));
//            child1V.setXuanXiuType(bundle.getString(s1+4));
//            child1V.setZhuanYeNumber(bundle.getString(s1+2));
//            child1V.setGrade(bundle.getString(s1+0));
//            child1V.setCredit(bundle.getString(s1+5));
//            child1V.setTime(bundle.getString(s1+6));
//            child1V.setOtherTime(bundle.getString(s1+7)+" "+bundle.getString(s1+8));
//            child1.add(child1V);
//            childData.add(child1);


    }


}
