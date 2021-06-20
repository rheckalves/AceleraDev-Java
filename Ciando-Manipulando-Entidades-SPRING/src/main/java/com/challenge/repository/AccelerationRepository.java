package com.challenge.repository;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long>  {

    Optional<Acceleration> findById(Long id);

    @Query(value = "SELECT * FROM acceleration a " +
            "INNER JOIN candidate ca " +
            "ON a.id = ca.acceleration_id " +
            "INNER JOIN company co " +
            "ON co.id = ca.company_id " +
            "WHERE co.id = :companyId", nativeQuery = true)
    List<Acceleration> findByCompany(@Param("companyId") Long companyId);
}
