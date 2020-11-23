package com.nexstacks.database;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity implements EmployeeListAdapter.EmployeeClickListener {

    private DatabaseHelper dbHelper;

    private RecyclerView mRcEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

//        Bundle data = getIntent().getExtras();
//
//        Employee employeeDetails = (Employee) data.getSerializable("EMPLOYEE");
//        Toast.makeText(ViewActivity.this, employeeDetails.getEmployeeName(), Toast.LENGTH_LONG).show();

        /**
         * 1.Linear
         * 2. Grid
         * 3. Staggered Grid
         */

        mRcEmployees = findViewById(R.id.rc_employee_list);

        mRcEmployees.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

//        mRcEmployees.setLayoutManager(new GridLayoutManager(this, 3));
//        mRcEmployees.setLayoutManager(new StaggeredGridLayoutManager(3, RecyclerView.VERTICAL));

        dbHelper = new DatabaseHelper(ViewActivity.this);
        setDataToAdapter();
    }


    public void onAddEmployeeClicked(View view) {
        startActivityForResult(new Intent(ViewActivity.this, MainActivity.class), 134);
    }


    private void setDataToAdapter() {
        ArrayList<Employee> employees = dbHelper.getEmployeesFromDatabase(dbHelper.getReadableDatabase());

        EmployeeListAdapter adapter = new EmployeeListAdapter(ViewActivity.this, employees);
        adapter.setListener(ViewActivity.this);
        mRcEmployees.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 134 && resultCode == Activity.RESULT_OK) {
            setDataToAdapter();
        } else if (requestCode == 190 && resultCode == Activity.RESULT_OK) {
            setDataToAdapter();
        }
    }

    @Override
    public void onEditEmployeeClicked(Employee employee) {
//        Toast.makeText(ViewActivity.this, "Edit Clicked", Toast.LENGTH_LONG).show();
        Intent editIntent = new Intent(ViewActivity.this, MainActivity.class);
        editIntent.putExtra(MainActivity.BUNDLE_IS_EDIT, true);
        editIntent.putExtra(MainActivity.BUNDLE_EMPLOYEE, employee);
        startActivityForResult(editIntent, 190);
    }

    @Override
    public void onDeleteEmployeeClicked(Employee employee) {
//        Toast.makeText(ViewActivity.this, "Delete Clicked", Toast.LENGTH_LONG).show();

        dbHelper.deleteEmployee(employee, dbHelper.getWritableDatabase());
        setDataToAdapter();
    }

}