package com.jesus.agenda;

import android.app.Application;

import com.jesus.agenda.dao.StudentDAO;
import com.jesus.agenda.model.Student;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        createStudentTest();
    }

    private void createStudentTest() {
        StudentDAO dao = new StudentDAO();
        dao.save(new Student("Felipin","1122334455","felipemartins@mail.com"));
        dao.save(new Student("Giovanna","1122334455","giovanna@mail.com"));
    }
}
