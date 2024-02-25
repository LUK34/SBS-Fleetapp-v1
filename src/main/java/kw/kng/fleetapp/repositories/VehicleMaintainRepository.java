package kw.kng.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kw.kng.fleetapp.models.VehicleMaintain;

@Repository
public interface VehicleMaintainRepository extends JpaRepository<VehicleMaintain, Integer> 
{

}
