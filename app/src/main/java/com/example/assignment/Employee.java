package com.example.assignment;

public class Employee {
    private int empId;
    private String name;
    private String dob;
    private String role;
    private int sno;

    public Employee(int sno,int empId, String name, String dob, String role) {
        this.sno=sno;
        this.empId = empId;
        this.name = name;
        this.dob = dob;
        this.role = role;
    }

    // Getters and setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public int getsno() {
        return sno;
    }

    public void setsno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

