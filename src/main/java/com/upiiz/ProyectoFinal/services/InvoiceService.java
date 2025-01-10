package com.upiiz.ProyectoFinal.services;

import com.upiiz.ProyectoFinal.entities.InvoiceEntity;
import com.upiiz.ProyectoFinal.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public InvoiceEntity saveInvoice(InvoiceEntity invoice) {
        return invoiceRepository.save(invoice);
    }

    public InvoiceEntity getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public List<InvoiceEntity> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public InvoiceEntity updateInvoice(InvoiceEntity invoice) {
        if (invoiceRepository.existsById(invoice.getId())) {
            return invoiceRepository.save(invoice);
        }
        return null;
    }

    public Boolean deleteInvoice(Long id) {
        if (invoiceRepository.existsById(id)) {
            invoiceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
