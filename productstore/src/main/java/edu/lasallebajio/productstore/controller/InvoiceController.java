package edu.lasallebajio.productstore.controller;

import edu.lasallebajio.productstore.model.Invoice;
import edu.lasallebajio.productstore.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Invoice> getInvoiceById(@PathVariable Long id) {
        return invoiceRepository.findById(id);
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        invoice.setId(id);
        return invoiceRepository.save(invoice);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        invoiceRepository.deleteById(id);
    }
}
