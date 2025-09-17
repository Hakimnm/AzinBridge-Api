package com.programmingtechie.azinbridgeapi.repository;


import com.programmingtechie.azinbridgeapi.models.entities.OrganizationProject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface OrganizationProjectRepository extends JpaRepository<OrganizationProject,Integer> {
    List<OrganizationProject> findAllByIsActiveTrue();
    Optional<OrganizationProject> findByIdAndIsActiveTrue(Integer id);
}
