package com.nexstacks.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mEtEmployeeID;
    private EditText mEtEmployeeName;
    private EditText mEtEmployeeEmail;
    private EditText mEtEmployeePhoneNumber;
    private EditText mEtEmployeeDesignation;

    private String selectedBloodGroup = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtEmployeeID = findViewById(R.id.et_emp_id);
        mEtEmployeeName = findViewById(R.id.et_emp_name);
        mEtEmployeeEmail = findViewById(R.id.et_emp_mail);
        mEtEmployeePhoneNumber = findViewById(R.id.et_emp_phone_number);
        mEtEmployeeDesignation = findViewById(R.id.et_emp_desingation);
        Spinner spnBloodGroup = findViewById(R.id.spn_bloodgroup);
        final String[] bloodGroups = getResources().getStringArray(R.array.bloodgroup);

        ArrayAdapter<String> bloodGroupAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.spinner_custom,
                R.id.spinner_text, bloodGroups);
        spnBloodGroup.setAdapter(bloodGroupAdapter);

        spnBloodGroup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    selectedBloodGroup = bloodGroups[position];
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onEnterEmployeeClicked(View view){
        String empID = mEtEmployeeID.getText().toString();
        String empName = mEtEmployeeName.getText().toString();
        String empEmail = mEtEmployeeEmail.getText().toString();
        long empPhoneNo = !mEtEmployeePhoneNumber.getText().toString().isEmpty() ?
                Long.parseLong(mEtEmployeePhoneNumber.getText().toString()) : 0;
        String empDesignation = mEtEmployeeDesignation.getText().toString();

        Employee newEmp = new Employee();
        newEmp.setEmployeeID(empID);
        newEmp.setEmployeeName(empName);


        Intent viewIntent = new Intent(MainActivity.this, ViewActivity.class);
        viewIntent.putExtra("EMPLOYEE", newEmp);
        startActivity(viewIntent);
//        viewIntent.putExtra("EMPID", empID);
//        viewIntent.putExtra("EMPNAME", empName);

    }
}