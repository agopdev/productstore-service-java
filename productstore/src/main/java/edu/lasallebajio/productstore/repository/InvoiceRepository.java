package edu.lasallebajio.productstore.repository;

import edu.lasallebajio.productstore.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
  
    List<Invoice> findByClientId(Long clientId);

    List<Invoice> findByBalanceGreaterThanEqual(Double balance);
}
