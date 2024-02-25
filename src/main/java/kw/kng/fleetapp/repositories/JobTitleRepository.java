package kw.kng.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kw.kng.fleetapp.models.JobTitle;


@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {

}
