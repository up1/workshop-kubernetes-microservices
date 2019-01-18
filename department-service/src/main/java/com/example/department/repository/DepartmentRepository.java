package com.example.department.repository;

import com.example.department.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, String> {

    List<Department> findByCompanyId(Long companyId);

}
