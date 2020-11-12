package com.nexstacks.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Bundle data = getIntent().getExtras();

        Employee employeeDetails = (Employee) data.getSerializable("EMPLOYEE");
        Toast.makeText(ViewActivity.this, employeeDetails.getEmployeeName(), Toast.LENGTH_LONG).show();
    }
}