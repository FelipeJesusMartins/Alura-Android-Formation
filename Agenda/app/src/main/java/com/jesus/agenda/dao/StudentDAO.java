package com.jesus.agenda.dao;

import androidx.annotation.Nullable;

import com.jesus.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();
    private static int idCounter = 1;

    public void save(Student student) {
        student.setId(idCounter);
        students.add(student);
        idCounter();
    }

    private void idCounter() {
        idCounter++;
    }

    public void edit(Student student) {
//        Student foundStudent;
        if (student != null) {
            int studentPosition = students.indexOf(student);
            students.set(studentPosition, student);
        }
    }

    @Nullable
    private Student searchStudentById(Student student) {
        for (Student a :
                students) {
            if (a.getId() == student.getId()) {
                return a;
            }
        }
        return null;
    }

    public void removeStudent(Student student) {
        Student studentFound = searchStudentById(student);
        if(studentFound != null){
            students.remove(studentFound);
        }
    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}