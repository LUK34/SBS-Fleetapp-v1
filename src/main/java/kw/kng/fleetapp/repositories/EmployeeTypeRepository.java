package kw.kng.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kw.kng.fleetapp.models.EmployeeType;


@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {

}
