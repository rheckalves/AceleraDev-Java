package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    @Query(value = "SELECT MAX(s.score) FROM submission s " +
            "INNER JOIN challenge ch " +
            "ON ch.id = s.challenge_id " +
            "GROUP BY ch.id " +
            "HAVING ch.id = :challengeId", nativeQuery = true)
    BigDecimal findHigherScoreByChallenge(@Param("challengeId") Long challengeId);

    @Query(value = "SELECT * FROM submission s " +
            "INNER JOIN challenge ch " +
            "ON s.challenge_id = ch.id " +
            "INNER JOIN acceleration a " +
            "ON a.challenge_id = ch.id " +
            "WHERE ch.id = :challengeId AND a.id = :accelerationId", nativeQuery = true)
    List<Submission> findByChallengeIdAndAcceleration(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}