package com.example.abhishek.assigmentproject;

import java.io.Serializable;

/**
 * Created by ABHISHEK on 9/23/2017.
 */

public class EmployeeBean implements Serializable {

    private int empid;
    private String empName;
    private String emailid;
    private String Unit;
    private String phoneNumber;


    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
