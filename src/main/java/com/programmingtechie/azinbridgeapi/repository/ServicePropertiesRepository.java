package com.programmingtechie.azinbridgeapi.repository;

import com.programmingtechie.azinbridgeapi.models.entities.ServiceProperties;
import com.programmingtechie.azinbridgeapi.models.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicePropertiesRepository extends JpaRepository<ServiceProperties,Integer> {
    List<ServiceProperties> findAllByIsActiveTrue();
    Optional<ServiceProperties> findByIdAndIsActiveTrue(Integer id);
}
