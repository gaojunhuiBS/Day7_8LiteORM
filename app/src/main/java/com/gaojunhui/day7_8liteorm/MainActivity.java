package com.gaojunhui.day7_8liteorm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.litesuits.orm.LiteOrm;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.bt_insert)
    Button btInsert;
    @InjectView(R.id.bt_delete)
    Button btDelete;
    @InjectView(R.id.bt_gai)
    Button btGai;
    @InjectView(R.id.bt_updata)
    Button btUpdata;
    private LiteOrm liteOrm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        if (liteOrm==null){
            liteOrm=LiteOrm.newCascadeInstance(this,"text.db");
        }
    }

    @OnClick({R.id.bt_insert, R.id.bt_delete, R.id.bt_gai, R.id.bt_updata})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_insert:
                Student student=new Student("zhangsan","男",25);
                liteOrm.insert(student);
                break;
            case R.id.bt_delete:
                Student s1=new Student("张三","男",25);
                s1.setId((long) 2);
                liteOrm.delete(s1);
                break;
            case R.id.bt_gai:
                Student student2=new Student("huahua","女",30);
                student2.setId((long) 4);
                liteOrm.update(student2);
                break;
            case R.id.bt_updata:
                List<Student> list=liteOrm.query(Student.class);
                for (Student student1:list){
                    Log.i("-----", "-----"+student1.getName()+student1.getSex()+student1.getId());
                }
                break;
        }
    }
}
