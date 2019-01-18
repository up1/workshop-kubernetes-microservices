package com.example.company.gateway;

import com.example.company.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "department")
public interface DepartmentGateway {

    @GetMapping("/company/{companyId}")
    public List<Department> findByOrganization(@PathVariable("companyId") String companyId);

}
