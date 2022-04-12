package com.jesus.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.jesus.agenda.R;
import com.jesus.agenda.dao.StudentDAO;
import com.jesus.agenda.model.Student;

public class FormRegisterActivity extends AppCompatActivity {

    private EditText fieldName;
    private EditText fieldNumber;
    private EditText fieldEmail;
    private final StudentDAO dao = new StudentDAO();
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);
        InitializeFields();
        loadStudent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.form_student_menu_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.form_student_menu_save_activity){
            finishForm();
        }
        return super.onOptionsItemSelected(item);
    }

    private void finishForm() {
        fillStudent();
        if (student.idIsValid()) {
            dao.edit(student);
        } else {
            dao.save(student);
        }
        finish();
    }

    private void loadStudent() {
        Intent intent = getIntent();

        if (intent.hasExtra(ConstantsActivity.STUDENT_KEY)) {
            setTitle(ConstantsActivity.TITLE_APPBAR_EDIT_STUDENT);
            student = (Student) intent.getSerializableExtra(ConstantsActivity.STUDENT_KEY);
            fillFields();
        } else {
            setTitle(ConstantsActivity.TITLE_APPBAR_NEW_STUDENT);
            student = new Student();
        }
    }

    private void fillFields() {
        fieldName.setText(student.getName());
        fieldNumber.setText(student.getNumber());
        fieldEmail.setText(student.getEmail());
    }

    private void InitializeFields() {
        fieldName = findViewById(R.id.activity_form_register_edit_student_name);
        fieldNumber = findViewById(R.id.activity_form_register_edit_student_phone);
        fieldEmail = findViewById(R.id.activity_form_register_edit_student_mail);
    }

    private void fillStudent() {
        String name = fieldName.getText().toString();
        String number = fieldNumber.getText().toString();
        String email = fieldEmail.getText().toString();

        student.setName(name);
        student.setNumber(number);
        student.setEmail(email);
    }
}