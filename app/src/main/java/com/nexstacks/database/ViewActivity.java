package com.nexstacks.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

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




    private void setDataToAdapter(){
        ArrayList<Employee> employees = dbHelper.getEmployeesFromDatabase(dbHelper.getReadableDatabase());

        EmployeeListAdapter adapter = new EmployeeListAdapter(ViewActivity.this, employees);

        mRcEmployees.setAdapter(adapter);
    }
}