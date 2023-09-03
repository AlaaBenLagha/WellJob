package com.pidev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.pidev.models.Collaboration;

@Repository
public interface CollaborationSpecificationRepository extends JpaRepository<Collaboration, Long>, JpaSpecificationExecutor<Collaboration>{


}