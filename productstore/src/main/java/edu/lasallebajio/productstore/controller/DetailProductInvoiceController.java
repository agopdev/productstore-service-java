package edu.lasallebajio.productstore.controller;

import edu.lasallebajio.productstore.model.DetailProductInvoice;
import edu.lasallebajio.productstore.repository.DetailProductInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detail-product-invoices")
public class DetailProductInvoiceController {

    @Autowired
    private DetailProductInvoiceRepository detailProductInvoiceRepository;

    @GetMapping
    public List<DetailProductInvoice> getAllDetailProductInvoices() {
        return detailProductInvoiceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DetailProductInvoice> getDetailProductInvoiceById(@PathVariable Long id) {
        return detailProductInvoiceRepository.findById(id);
    }

    @PostMapping
    public DetailProductInvoice createDetailProductInvoice(@RequestBody DetailProductInvoice detailProductInvoice) {
        return detailProductInvoiceRepository.save(detailProductInvoice);
    }

    @PutMapping("/{id}")
    public DetailProductInvoice updateDetailProductInvoice(@PathVariable Long id, @RequestBody DetailProductInvoice detailProductInvoice) {
        detailProductInvoice.setId(id);
        return detailProductInvoiceRepository.save(detailProductInvoice);
    }

    @DeleteMapping("/{id}")
    public void deleteDetailProductInvoice(@PathVariable Long id) {
        detailProductInvoiceRepository.deleteById(id);
    }
}
