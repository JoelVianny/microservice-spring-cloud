package com.example.eurekaorganization.repository;

import com.example.eurekaorganization.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository  extends JpaRepository<Organization,Long> {
}
