package com.example.AssesmentCRM;

import com.example.AssesmentCRM.repositories.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CRM_BASIC implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CRM_BASIC.class, args);
    }

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Override
    public void run(String... args) throws Exception {

/* GENERATE
		OpportunityEntity opportunity_entity = new OpportunityEntity();
		opportunity_entity.setOpportunityName("Jose Manuel");
		opportunity_entity.setOpportunityPhone("JoseManuel12!");
		opportunity_entity.setOpportunityEmail("JoseManuel@solera.com");
		opportunity_entity.setVisible(1);
		opportunityRepository.save(opportunity_entity);
*/

}
}
