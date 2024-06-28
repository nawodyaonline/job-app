package com.incognito.jobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Company company, @PathVariable Long id) {
        companyService.updateCompany(company, id);
        return new ResponseEntity<>("Update successfully!", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Company company) {        ;
        return new ResponseEntity<>("Create successfully! " + companyService.createCompany(company).toString(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
    }

}
