package com.challenge.service;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService implements ChallengeServiceInterface {

    @Autowired
    private final ChallengeRepository challengeRepository;

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return challengeRepository.findByAccelerationAndUser(accelerationId, userId);
    }

    @Override
    public Challenge save(Challenge challenge) {
        return challengeRepository.save(challenge);
    }
}
