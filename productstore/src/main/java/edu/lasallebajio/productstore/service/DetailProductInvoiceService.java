package edu.lasallebajio.productstore.service;

import edu.lasallebajio.productstore.model.DetailProductInvoice;
import edu.lasallebajio.productstore.repository.DetailProductInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailProductInvoiceService {

    @Autowired
    private DetailProductInvoiceRepository detailProductInvoiceRepository;
    
    public List<DetailProductInvoice> getAllDetailProductInvoices() {
        return detailProductInvoiceRepository.findAll();
    }

    public Optional<DetailProductInvoice> getDetailProductInvoiceById(Long id) {
        return detailProductInvoiceRepository.findById(id);
    }

    public List<DetailProductInvoice> getDetailsByInvoiceId(Long invoiceId) {
        return detailProductInvoiceRepository.findByInvoiceId(invoiceId);
    }

    public DetailProductInvoice createDetailProductInvoice(DetailProductInvoice detailProductInvoice) {
        return detailProductInvoiceRepository.save(detailProductInvoice);
    }

    public void deleteDetailProductInvoice(Long id) {
        detailProductInvoiceRepository.deleteById(id);
    }
}
