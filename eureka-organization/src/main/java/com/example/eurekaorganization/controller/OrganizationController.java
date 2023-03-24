package com.example.eurekaorganization.controller;

import com.example.eurekaorganization.entities.Organization;
import com.example.eurekaorganization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    @GetMapping("/{id}")
    public Organization getOneOrganization(@PathVariable long id){
        return  organizationService.getOrganization(id);
    }

    @GetMapping
    public List<Organization> getAllOrganization(){
        return  organizationService.getAllOrganization();
    }

    @PostMapping
    public Organization createOrganization(@RequestBody Organization organization){
        return organizationService.createOrganization(organization);

    }
    @PutMapping("/{id}")
    public Organization update(@PathVariable long id,@RequestBody Organization organization){
        return  organizationService.updateOrganization(id,organization);
    }

    @DeleteMapping("/{id}")
    public String deleteOrganization(@PathVariable long id){
        return  organizationService.deleteOrganization(id);
    }
}
