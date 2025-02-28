package edu.lasallebajio.productstore.repository;

import edu.lasallebajio.productstore.model.Status;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
  
    Optional<Status> findByName(String name);
}
