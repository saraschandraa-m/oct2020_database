package com.nexstacks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "employee_info";

    private static final String COL_ID = "id";
    private static final String COL_EMP_ID = "emp_id";
    private static final String COL_EMP_NAME = "emp_name";
    private static final String COL_EMP_EMAIL = "emp_email";
    private static final String COL_EMP_MOB = "emp_mob";
    private static final String COL_EMP_BLOOD = "emp_blood";
    private static final String COL_EMP_DESN = "emp_desgn";

    //CREATE TABLE employee_info(id INTEGER PRIMARY KEY AUTOINCREMENT,emp_id TEXT,emp_name TEXT,emp_email TEXT,emp_mob INTEGER,emp_blood TEXT,
    //emp_desgn TEXT)


    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_EMP_ID +" TEXT,"+
            COL_EMP_MOB+" INTEGER,"+COL_EMP_NAME+" TEXT,"+COL_EMP_EMAIL+" TEXT,"+ COL_EMP_BLOOD + " TEXT," +COL_EMP_DESN +" TEXT)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "employeeinfo.db", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertDataToDatabase(SQLiteDatabase db, Employee employee){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMP_ID, employee.getEmployeeID());
        contentValues.put(COL_EMP_NAME, employee.getEmployeeName());
        contentValues.put(COL_EMP_MOB, employee.getEmployeePhoneNumber());
        contentValues.put(COL_EMP_EMAIL, employee.getEmployeeEmail());
        contentValues.put(COL_EMP_BLOOD, employee.getEmployeeBloodGroup());
        contentValues.put(COL_EMP_DESN, employee.getEmployeeDesignation());


       long value =  db.insert(TABLE_NAME, null, contentValues);
        Log.i("DATABASE INSERT VALUE", String.valueOf(value));

    }



    public ArrayList<Employee> getEmployeesFromDatabase(SQLiteDatabase db){
        ArrayList<Employee> employeeList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);


        if(cursor.moveToFirst()){
            do{
                Employee employeeInfo = new Employee();
                employeeInfo.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
                employeeInfo.setEmployeeID(cursor.getString(cursor.getColumnIndex(COL_EMP_ID)));
                employeeInfo.setEmployeeName(cursor.getString(cursor.getColumnIndex(COL_EMP_NAME)));
                employeeInfo.setEmployeeEmail(cursor.getString(cursor.getColumnIndex(COL_EMP_EMAIL)));
                employeeInfo.setEmployeePhoneNumber((long) cursor.getInt(cursor.getColumnIndex(COL_EMP_MOB)));
                employeeInfo.setEmployeeDesignation(cursor.getString(cursor.getColumnIndex(COL_EMP_DESN)));
                employeeInfo.setEmployeeBloodGroup(cursor.getString(cursor.getColumnIndex(COL_EMP_BLOOD)));
                employeeList.add(employeeInfo);
            }while(cursor.moveToNext());
        }

        return employeeList;
    }

    public void deleteEmployee(Employee employee, SQLiteDatabase database){
        database.delete(TABLE_NAME, COL_ID +"="+employee.getId(), null);
    }

    public void updateEmployee(Employee employee, SQLiteDatabase database){
        ContentValues cv = new ContentValues();
        cv.put(COL_EMP_ID, employee.getEmployeeID());
        cv.put(COL_EMP_NAME, employee.getEmployeeName());
        cv.put(COL_EMP_MOB, employee.getEmployeePhoneNumber());
        cv.put(COL_EMP_EMAIL, employee.getEmployeeEmail());
        cv.put(COL_EMP_BLOOD, employee.getEmployeeBloodGroup());
        cv.put(COL_EMP_DESN, employee.getEmployeeDesignation());

        database.update(TABLE_NAME,cv, COL_ID+"="+employee.getId(), null );
    }
}
