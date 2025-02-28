package edu.lasallebajio.productstore.repository;

import edu.lasallebajio.productstore.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByUsername(String username);
    
    List<Employee> findByLastName(String lastName);
}
