package com.jesus.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jesus.agenda.R;
import com.jesus.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ListStudentsAdapter extends BaseAdapter {

    private final List<Student> students = new ArrayList<>();
    private final Context context;

    public ListStudentsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return students.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View createdView = LayoutInflater.from(context).inflate(R.layout.student_item, viewGroup, false);
        Student returnedStudent = students.get(position);
        linkNames(createdView, returnedStudent);
        return createdView;
    }

    private void linkNames(View createdView, Student returnedStudent) {
        TextView name = createdView.findViewById(R.id.student_item_name);
        TextView number = createdView.findViewById(R.id.student_item_cellphone);
        TextView email = createdView.findViewById(R.id.student_item_email);

        name.setText(returnedStudent.getName());
        number.setText(returnedStudent.getNumber());
        email.setText(returnedStudent.getEmail());
    }

    public void remove(Student student) {
        students.remove(student);
        notifyDataSetChanged();
    }

    public void update(List<Student> students) {
        this.students.clear();
        this.students.addAll(students);
        notifyDataSetChanged();
    }
}
