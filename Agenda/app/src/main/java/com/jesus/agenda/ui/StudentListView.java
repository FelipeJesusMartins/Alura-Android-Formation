package com.jesus.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jesus.agenda.dao.StudentDAO;
import com.jesus.agenda.model.Student;
import com.jesus.agenda.ui.adapter.ListStudentsAdapter;

public class StudentListView {

    private final ListStudentsAdapter adapter;
    private final StudentDAO dao;
    private final Context context;

    public StudentListView(Context context) {
        this.context = context;
        this.adapter = new ListStudentsAdapter(context);
        this.dao = new StudentDAO();
    }

    public void confirmRemove(final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo Aluno")
                .setMessage("Tem certeza que deseja remover o aluno ?")
                .setPositiveButton("Sim", (dialog, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Student selectedStudent = adapter.getItem(menuInfo.position);
                    remove(selectedStudent);
                })
                .setNegativeButton("Não", null)
                .show();
    }

    private void remove(Student student) {
        dao.removeStudent(student);
        adapter.remove(student);
    }

    public void listStudents() {
        adapter.update(dao.getAllStudents());
    }

    public void setUpAdapter(ListView studentList) {
        studentList.setAdapter(adapter);
    }
}
