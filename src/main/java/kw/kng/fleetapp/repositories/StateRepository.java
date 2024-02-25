package kw.kng.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import kw.kng.fleetapp.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
