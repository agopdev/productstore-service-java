package edu.lasallebajio.productstore.repository;

import edu.lasallebajio.productstore.model.DetailProductInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailProductInvoiceRepository extends JpaRepository<DetailProductInvoice, Long> {
  
    List<DetailProductInvoice> findByInvoiceId(Long invoiceId);

    List<DetailProductInvoice> findByProductId(Long productId);
}
