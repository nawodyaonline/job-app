package com.incognito.jobapp.company;


import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    Company createCompany(Company company);
    void updateCompany(Company company, Long id);
    boolean deleteCompanyById(Long id);

}
