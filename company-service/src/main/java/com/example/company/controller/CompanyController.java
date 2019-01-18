package com.example.company.controller;

import com.example.company.gateway.DepartmentGateway;
import com.example.company.model.Company;
import com.example.company.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CompanyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    CompanyRepository repository;

    @Autowired
    DepartmentGateway departmentGateway;

    @PostMapping
    public Company add(@RequestBody Company company) {
        LOGGER.info("Company add: {}", company);
        return repository.save(company);
    }

    @GetMapping
    public Iterable<Company> findAll() {
        LOGGER.info("Company find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Company findById(@PathVariable("id") String id) {
        LOGGER.info("Organization find: id={}", id);
        return repository.findById(id).get();
    }

    @GetMapping("/{id}/with-departments")
    public Company findByIdWithDepartments(@PathVariable("id") String id) {
        LOGGER.info("Organization find: id={}", id);
        Optional<Company> company = repository.findById(id);
        if (company.isPresent()) {
            Company currentCompany = company.get();
            currentCompany.setDepartments(departmentGateway.findByOrganization(currentCompany.getId()));
            return currentCompany;
        } else {
            return null;
        }
    }

}
