package com.example.eurekaorganization.service;

import com.example.eurekaorganization.entities.Organization;
import com.example.eurekaorganization.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public Organization getOrganization( long id){
        return  organizationRepository.findById(id).orElseThrow( ()->new IllegalArgumentException("not found"));
    }

    public List<Organization> getAllOrganization(){
        return  organizationRepository.findAll();
    }

    public Organization createOrganization(Organization organization){
        log.info(organization.toString());
        Organization  organization1 = organizationRepository.save(organization);
        log.info(organization1.toString());
        return  organization1;
    }

    public Organization updateOrganization(long id, Organization organization){
        log.info(organization.toString());
        Organization foundOrganization = getOrganization(id);
                    foundOrganization.setName(organization.getName());
                    foundOrganization.setDescription(organization.getDescription());
               log.info(foundOrganization.toString());
         return       organizationRepository.save(foundOrganization);
    }

    public String deleteOrganization(long id){
        organizationRepository.delete(getOrganization(id));

        return  "Organization deleted";
    }
}
