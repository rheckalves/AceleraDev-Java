package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    Optional<Company> findById(Long id);

    @Query(value = "SELECT * FROM company co " +
            "INNER JOIN candidate ca " +
            "ON co.id = ca.company_id " +
            "INNER JOIN users u " +
            "ON u.id = ca.user_id " +
            "WHERE u.id = :userId", nativeQuery = true)
    List<Company> findByUserId(@Param("userId") Long userId);
}
