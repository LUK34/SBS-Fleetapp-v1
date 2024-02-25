package kw.kng.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kw.kng.fleetapp.models.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> 
{

}
