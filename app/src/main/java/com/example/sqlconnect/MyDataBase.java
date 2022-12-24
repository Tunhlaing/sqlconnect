package com.example.sqlconnect;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    private static final String DB_NAME = "STUDENT_DB";
    private static final int DB_VERSION = 1;
    private final String STUDENT_TABLE = "dbl_student";
    private final String STUDENT_ID = "student_id";
    private final String STUDENT_NAME = "student_name";
    private final String STUDENT_GRADE = "student_grade";
    private final String STUDENT_ROOM = "student_room";
    private final String STUDENT_FATHER = "student_father";

    public MyDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //String query = "CREATE TABLE " + DBL_STUDENT + "(g_id INTEGER PRIMARY KEY AUTOINCREMENT, g_name TEXT)";
        //sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + STUDENT_TABLE +
                        " (" + STUDENT_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        STUDENT_NAME + " TEXT, " +
                        STUDENT_GRADE + " TEXT, " +
                        STUDENT_ROOM + "TEXT, " +
                        STUDENT_FATHER + "TEXT);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

     boolean insertStudent(String name, String grade, String room, String father) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(STUDENT_NAME, name);
        cv.put(STUDENT_GRADE, grade);
        cv.put(STUDENT_ROOM, room);
        cv.put(STUDENT_FATHER, father);
         try {
             database.insert(STUDENT_TABLE, null, cv);
             database.close();
             return true;
         } catch (Exception e) {
             e.printStackTrace();
             database.close();
             return  false;
         }

     }

}
