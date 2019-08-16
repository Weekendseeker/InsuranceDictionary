package org.marvin.insurance_dictionary.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceCompany {

    private long inn;
    private long ogrn;
    private String name;
    private String address;

}
