package org.marvin.insurance_dictionary.implsRepositories;

import org.marvin.insurance_dictionary.models.InsuranceCompany;
import org.marvin.insurance_dictionary.repositories.InsuranceCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcInsuranceCompanyRepository implements InsuranceCompanyRepository {

    private JdbcTemplate template;

    @Override
    public Iterable<InsuranceCompany> findAll() {
        return template.query("SELECT * FROM INSURANCE_COMPANY",
                this::mappingFromResult
                );
    }

    @Override
    public Iterable<InsuranceCompany> findByInn(long inn) {

        return template.query("SELECT * FROM INSURANCE_COMPANY where INN = ?",
                new Object[]{inn},
                this::mappingFromResult);

    }

    @Override
    public Iterable<InsuranceCompany> findByOgrn(long orgn) {

        return template.query("SELECT * FROM INSURANCE_COMPANY where ORGN = ?",
                new Object[]{orgn},
                this::mappingFromResult ) ;
    }

    @Override
    public Iterable<InsuranceCompany> findByAddress(String address) {
        return template.query("SELECT * FROM INSURANCE_COMPANY where ADDRESS = ?",
                new Object[]{address},
                this::mappingFromResult );
    }

    @Override
    public Iterable<InsuranceCompany> findByName(String name) {
        return template.query("SELECT * FROM INSURANCE_COMPANY where NAME = ?",
                new Object[]{name},
                this::mappingFromResult );
    }

    private InsuranceCompany mappingFromResult(ResultSet rs, int row) throws SQLException {

        return new InsuranceCompany(

                rs.getLong("INN"),
                rs.getLong("ORGN"),
                rs.getString("NAME"),
                rs.getString("ADDRESS"));

    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }
}
