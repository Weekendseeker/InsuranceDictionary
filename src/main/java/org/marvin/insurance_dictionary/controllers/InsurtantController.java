package org.marvin.insurance_dictionary.controllers;


import org.marvin.insurance_dictionary.models.InsuranceCompany;
import org.marvin.insurance_dictionary.repositories.InsuranceCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InsurtantController {


    private InsuranceCompanyRepository insuranceCompanyRepository;


    @GetMapping("/insuranceCompanies")
    public String insurantMain(Model model){

        List<InsuranceCompany> companies = new ArrayList<>();

        insuranceCompanyRepository.findAll().forEach(companies::add);

        model.addAttribute("companies",companies);

        return "MainTemplate";
    }
    @GetMapping(value = "/insuranceCompanies/search", params = "search=byName")
    public String searchByName(@RequestParam String searchParam, Model model){

        List<InsuranceCompany> companies = new ArrayList<>();

        insuranceCompanyRepository.findByName(searchParam).forEach(companies::add);

        model.addAttribute("companies",companies);

        return "MainTemplate";
    }

    @GetMapping(value = "/insuranceCompanies/search", params = "search=byInn")
    public String searchByInn(@RequestParam String searchParam, Model model){

        List<InsuranceCompany> companies = new ArrayList<>();

        long inn;
        try {
             inn = Long.parseLong(searchParam);
        } catch (NumberFormatException e){
            return "MainTemplate";
        }


        insuranceCompanyRepository.findByInn(inn).forEach(companies::add);

        model.addAttribute("companies",companies);

        return "MainTemplate";
    }

    @GetMapping(value = "/insuranceCompanies/search", params = "search=byAddress")
    public String searchByAddress(@RequestParam String searchParam, Model model){

        List<InsuranceCompany> companies = new ArrayList<>();

        insuranceCompanyRepository.findByAddress(searchParam).forEach(companies::add);

        model.addAttribute("companies",companies);

        return "MainTemplate";
    }


    @GetMapping(value = "/insuranceCompanies/search", params = "search=byOgrn")
    public String searchByAd(@RequestParam String searchParam, Model model){

        List<InsuranceCompany> companies = new ArrayList<>();

        long ogrn;
        try {
            ogrn = Long.parseLong(searchParam);
        } catch (NumberFormatException e){
            return "MainTemplate";
        }
        insuranceCompanyRepository.findByOgrn(ogrn).forEach(companies::add);

        model.addAttribute("companies",companies);

        return "MainTemplate";
    }

    @Autowired
    public void setInsuranceCompanyRepository(InsuranceCompanyRepository insuranceCompanyRepository) {
        this.insuranceCompanyRepository = insuranceCompanyRepository;
    }

    public InsuranceCompanyRepository getInsuranceCompanyRepository() {
        return insuranceCompanyRepository;
    }
}
