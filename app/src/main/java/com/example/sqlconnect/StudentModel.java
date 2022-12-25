package com.example.sqlconnect;

public class StudentModel {
     private int studentId;
     private String studentName;
     private String studentGrade;
     private String studentRoom;
     private String studentFather;

     public StudentModel(int studentId, String studentName, String studentGrade, String studentRoom, String studentFather) {
          this.studentId = studentId;
          this.studentName = studentName;
          this.studentGrade = studentGrade;
          this.studentRoom = studentRoom;
          this.studentFather = studentFather;
     }

     public int getStudentId() {
          return studentId;
     }

     public String getStudentName() {
          return studentName;
     }

     public String getStudentGrade() {
          return studentGrade;
     }

     public String getStudentRoom() {
          return studentRoom;
     }

     public String getStudentFather() {
          return studentFather;
     }
}
