package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query(value = "SELECT * FROM challenge ch " +
            "INNER JOIN acceleration a " +
            "ON a.challenge_id = ch.id " +
            "INNER JOIN candidate c " +
            "ON c.acceleration_id = a.id " +
            "INNER JOIN users u " +
            "ON u.id = c.user_id " +
            "WHERE u.id = :userId AND a.id = :accelerationId", nativeQuery = true)
    List<Challenge> findByAccelerationAndUser(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);

}
