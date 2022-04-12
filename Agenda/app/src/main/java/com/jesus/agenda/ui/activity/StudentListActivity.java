package com.jesus.agenda.ui.activity;

import static com.jesus.agenda.ui.activity.ConstantsActivity.STUDENT_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jesus.agenda.R;
import com.jesus.agenda.model.Student;
import com.jesus.agenda.ui.StudentListView;

public class StudentListActivity extends AppCompatActivity {

    private final StudentListView studentListView = new StudentListView(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        setTitle(R.string.Title);
        fabConfiguration();
        setUpList();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.list_students_menu_activity, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.list_students_menu_remove_activity) {
            studentListView.confirmRemove(item);

        }

        return super.onContextItemSelected(item);
    }


    private void setUpList() {
        ListView studentList = findViewById(R.id.activity_student_list_listview);
        studentListView.setUpAdapter(studentList);
        setUpListenerByItem(studentList);
        registerForContextMenu(studentList);
    }

    private void setUpListenerByItem(ListView studentList) {
        studentList.setOnItemClickListener((adapterView, view, position, id) -> {
            Student selectedStudent = (Student) adapterView.getItemAtPosition(position);
            openFormEditStudent(selectedStudent);
        });
    }

    private void openFormEditStudent(Student student) {
        Intent goToFormActivity = new Intent(StudentListActivity.this, FormRegisterActivity.class);
        goToFormActivity.putExtra(STUDENT_KEY, student);
        startActivity(goToFormActivity);
    }




    private void fabConfiguration() {
        FloatingActionButton fabAddStudent = findViewById(R.id.activity_student_fab_add_student);
        fabAddStudent.setOnClickListener(view -> startActivity(new Intent(this, FormRegisterActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentListView. listStudents();
    }
}
