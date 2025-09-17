package com.programmingtechie.azinbridgeapi.repository;

import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
import com.programmingtechie.azinbridgeapi.models.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organizations,Integer> {
    List<Organizations> findAllByIsActiveTrue();
    Optional<Organizations> findByIdAndIsActiveTrue(Integer id);
}
