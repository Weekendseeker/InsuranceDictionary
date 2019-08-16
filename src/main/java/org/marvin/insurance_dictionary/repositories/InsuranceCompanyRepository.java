package org.marvin.insurance_dictionary.repositories;

import org.marvin.insurance_dictionary.models.InsuranceCompany;

public interface InsuranceCompanyRepository {


    Iterable<InsuranceCompany> findAll();
    Iterable<InsuranceCompany> findByInn(long inn);
    Iterable<InsuranceCompany> findByOgrn(long ogrn);
    Iterable<InsuranceCompany> findByAddress(String address);
    Iterable<InsuranceCompany> findByName(String name);

}
