package com.programmingtechie.azinbridgeapi.repository;

import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
import com.programmingtechie.azinbridgeapi.models.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<Services,Integer> {
    List<Services> findAllByIsActiveTrue();
    Optional<Services> findByIdAndIsActiveTrue(Integer id);
}
