package com.nexstacks.database;

import java.io.Serializable;

public class Employee implements Serializable {

//    public int id;
//    public String employeeID;
//    public String employeeName;
//    public String employeeEmail;
//    public long employeePhoneNumber;
//    public String employeeDesignation;
//    public String employeeBloodGroup;

    private int id;
    private String employeeID;
    private String employeeName;
    private String employeeEmail;
    private long employeePhoneNumber;
    private String employeeDesignation;
    private String employeeBloodGroup;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public long getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(long employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public String getEmployeeBloodGroup() {
        return employeeBloodGroup;
    }

    public void setEmployeeBloodGroup(String employeeBloodGroup) {
        this.employeeBloodGroup = employeeBloodGroup;
    }
}
