package com.example.department.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
public class Department {

    @Id
    private String id;
    private Long companyId;
    private String name;

    public Department() {
    }

    public Department(Long companyId, String name) {
        super();
        this.companyId = companyId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCompanynId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Department [id=" + id + ", companyId=" + companyId + ", name=" + name + "]";
    }

}
