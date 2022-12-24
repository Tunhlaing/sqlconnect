package com.example.sqlconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddStudentPage extends AppCompatActivity {
    EditText etStudentName, etStudentGrade, etStudentRoomNo,etStudentFather;
    RadioButton rbFemale,rbMale;
    Button btAddStudent;
    MyDataBase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_page);
        initView();
        db = new MyDataBase(this);
        handleClick();
    }

    private void initView(){
        etStudentName = findViewById(R.id.etStudentName);
        etStudentFather = findViewById(R.id.etStudentFather);
        etStudentGrade = findViewById(R.id.etStudentGrade);
        etStudentRoomNo = findViewById(R.id.etStudentRoomNo);
        rbFemale = findViewById(R.id.rbFemale);
        rbMale = findViewById(R.id.rbMale);
        btAddStudent=findViewById(R.id.btAddStudent);

    }
    private void handleClick(){
        btAddStudent.setOnClickListener(view -> {

            if (db.insertStudent(etStudentName.getText().toString().trim(),
                    etStudentGrade.getText().toString().trim(),
                    etStudentRoomNo.getText().toString().trim(),
                    etStudentFather.getText().toString().trim())) {
                Toast.makeText(this,"passed",Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show();
            }
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);

        });
    }
}
