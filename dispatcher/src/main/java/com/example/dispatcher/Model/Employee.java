package com.example.dispatcher.Model;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private boolean available;
    private String employeeType;
    private int callId;

    public Employee(){}

    public Employee(String name, EmployeeType employeeType) {
        this.name = name;
        this.employeeType = employeeType.toString();
        this.available = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }
}
