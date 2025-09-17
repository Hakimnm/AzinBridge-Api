package com.programmingtechie.azinbridgeapi.repository;

import com.programmingtechie.azinbridgeapi.models.entities.Organizations;
import com.programmingtechie.azinbridgeapi.models.entities.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectStatusRepository extends JpaRepository<ProjectStatus,Integer> {
    List<ProjectStatus> findAllByIsActiveTrue();
    Optional<ProjectStatus> findByIdAndIsActiveTrue(Integer id);
}
