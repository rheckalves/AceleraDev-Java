package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

    Optional<Candidate> findById(CandidateId id);

    @Query(value = "SELECT * FROM candidate " +
            "INNER JOIN acceleration a " +
            "ON a.id = candidate.acceleration_id " +
            "WHERE a.id = :accelerationId", nativeQuery = true)
    List<Candidate> findByAcceleration(@Param("accelerationId") Long accelerationId);

    @Query(value = "SELECT * FROM candidate ca " +
            "INNER JOIN company c " +
            "ON c.id = ca.company_id " +
            "WHERE c.id = :companyId", nativeQuery = true)
    List<Candidate> findByCompany(@Param("companyId") Long companyId);
}
