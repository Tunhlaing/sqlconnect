package com.example.sqlconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvStudent;
    ImageView btEdit, btDelete;
    MyDataBase db;
    FloatingActionButton btAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setAdapter();
        handleClick();
        db = new MyDataBase(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" in XML
        rvStudent.setLayoutManager(linearLayoutManager);




    }

    private void initView(){
        rvStudent = findViewById(R.id.rvStudent);
        btEdit = findViewById(R.id.btEdit);
        btDelete = findViewById(R.id.btDelete);
        btAdd=findViewById(R.id.btAdd);

    }
    private void setAdapter(){
        StudentAdapter studentAdapter = new StudentAdapter(dummyStudentList());
        rvStudent.setAdapter(studentAdapter);
    }
    private void handleClick(){
        btAdd.setOnClickListener(view -> {
            Intent i = new Intent(this,AddStudentPage.class);
            startActivity(i);


        });


    }



    private ArrayList<String> dummyStudentList(){
        ArrayList<String> studentList = new ArrayList<>();
        studentList.add("Tun Tun");
        studentList.add("Mg Mg");
        studentList.add("Su Su");
        studentList.add("Kyaw Kyaw");
        studentList.add("Susan");
        studentList.add("Moe Moe");

        return  studentList;

    }
}