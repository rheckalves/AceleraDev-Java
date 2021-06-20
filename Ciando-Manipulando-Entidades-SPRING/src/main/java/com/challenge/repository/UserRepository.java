package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long userId);

    @Query(value = "select * from users user " +
            "INNER JOIN candidate c " +
            "ON user.id = c.user_id " +
            "INNER JOIN acceleration a " +
            "ON a.id = c.acceleration_id " +
            "where a.name like %:nomeAcceleration%", nativeQuery = true)
    List<User> findByAccelerationName(@Param("nomeAcceleration") String name);

    @Query(value = "select * from users user " +
            "INNER JOIN candidate c " +
            "ON user.id = c.user_id " +
            "INNER JOIN company co " +
            "ON co.id = c.company_id " +
            "where co.id = :idCompany", nativeQuery = true)
    List<User> findByCompanyId(@Param("idCompany") Long companyId);
}
