package kw.kng.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kw.kng.fleetapp.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
