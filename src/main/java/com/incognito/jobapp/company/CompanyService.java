package com.incognito.jobapp.company;


import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(String id);
    Company createCompany(Company company);
    boolean updateCompany(Company company, Long id);

}
