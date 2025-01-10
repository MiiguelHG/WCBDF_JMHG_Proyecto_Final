package com.upiiz.ProyectoFinal.repositories;

import com.upiiz.ProyectoFinal.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
}
