package com.upiiz.ProyectoFinal.controllers;

import com.upiiz.ProyectoFinal.entities.CustomResponse;
import com.upiiz.ProyectoFinal.entities.InvoiceEntity;
import com.upiiz.ProyectoFinal.services.InvoiceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1/invoices")
@Tag(name = "Invoices", description = "API para administrar las facturas")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    // Implementar los métodos del controlador
    // POST
    @PostMapping
    public ResponseEntity<CustomResponse<InvoiceEntity>> saveInvoice(@RequestBody InvoiceEntity invoice) {
        Link invoicesLinks = linkTo(InvoiceController.class).withSelfRel();
        List<Link> links = List.of(invoicesLinks);

        try {
            InvoiceEntity newInvoice = invoiceService.saveInvoice(invoice);

            if (newInvoice == null) {
                CustomResponse<InvoiceEntity> response = new CustomResponse<>(0, "Factura no guardada", null, links);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            CustomResponse<InvoiceEntity> response = new CustomResponse<>(1, "Factura guardada con éxito", newInvoice, links);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            CustomResponse<InvoiceEntity> response = new CustomResponse<>(0, "Error al guardar la factura", null, links);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // GET
    @GetMapping
    public ResponseEntity<CustomResponse<List<InvoiceEntity>>> findAllInvoices() {
        Link invoicesLinks = linkTo(InvoiceController.class).withSelfRel();
        List<Link> links = List.of(invoicesLinks);

        try {
            List<InvoiceEntity> invoices = invoiceService.getAllInvoices();

            if (invoices.isEmpty()) {
                CustomResponse<List<InvoiceEntity>> response = new CustomResponse<>(0, "No hay facturas registradas", null, links);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            CustomResponse<List<InvoiceEntity>> response = new CustomResponse<>(1, "Facturas encontradas", invoices, links);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            CustomResponse<List<InvoiceEntity>> response = new CustomResponse<>(0, "Error al buscar las facturas", null, links);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<InvoiceEntity>> findInvoiceById(@PathVariable Long id) {
        Link invoicesLinks = linkTo(InvoiceController.class).withSelfRel();
        List<Link> links = List.of(invoicesLinks);

        try {
            InvoiceEntity invoice = invoiceService.getInvoiceById(id);

            if (invoice == null) {
                CustomResponse<InvoiceEntity> response = new CustomResponse<>(0, "Factura no encontrada", null, links);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            CustomResponse<InvoiceEntity> response = new CustomResponse<>(1, "Factura encontrada", invoice, links);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            CustomResponse<InvoiceEntity> response = new CustomResponse<>(0, "Error al buscar la factura", null, links);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<InvoiceEntity>> updateInvoice(@PathVariable Long id, @RequestBody InvoiceEntity invoice) {
        Link invoicesLinks = linkTo(InvoiceController.class).withSelfRel();
        List<Link> links = List.of(invoicesLinks);

        try {
            invoice.setId(id);
            InvoiceEntity updatedInvoice = invoiceService.updateInvoice(invoice);

            if (updatedInvoice == null) {
                CustomResponse<InvoiceEntity> response = new CustomResponse<>(0, "Factura no actualizada", null, links);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            CustomResponse<InvoiceEntity> response = new CustomResponse<>(1, "Factura actualizada con éxito", updatedInvoice, links);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            CustomResponse<InvoiceEntity> response = new CustomResponse<>(0, "Error al actualizar la factura", null, links);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse<InvoiceEntity>> deleteInvoice(@PathVariable Long id) {
        Link invoicesLinks = linkTo(InvoiceController.class).withSelfRel();
        List<Link> links = List.of(invoicesLinks);

        try {
            Boolean deleted = invoiceService.deleteInvoice(id);

            if (!deleted) {
                CustomResponse<InvoiceEntity> response = new CustomResponse<>(0, "Factura no eliminada", null, links);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            CustomResponse<InvoiceEntity> response = new CustomResponse<>(1, "Factura eliminada con éxito", null, links);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            CustomResponse<InvoiceEntity> response = new CustomResponse<>(0, "Error al eliminar la factura", null, links);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
