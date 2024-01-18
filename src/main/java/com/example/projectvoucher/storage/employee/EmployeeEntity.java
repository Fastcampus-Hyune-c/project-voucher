package com.example.projectvoucher.storage.employee;

import com.example.projectvoucher.storage.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "employee")
@Entity
public class EmployeeEntity extends BaseEntity {
    private String name;
    private String position;
    private String department;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String name, String position, String department) {
        this.name = name;
        this.position = position;
        this.department = department;
    }

    public String name() {
        return name;
    }

    public String position() {
        return position;
    }

    public String department() {
        return department;
    }
}
