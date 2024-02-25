package kw.kng.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import kw.kng.fleetapp.models.VehicleMa;

@Repository
public interface VehicleMaRepository extends JpaRepository<VehicleMa, Integer> 
{

}
