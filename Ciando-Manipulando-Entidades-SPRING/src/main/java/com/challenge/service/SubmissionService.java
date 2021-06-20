package com.challenge.service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SubmissionService implements SubmissionServiceInterface {

    @Autowired
    private final SubmissionRepository submissionRepository;

    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Override
    public Submission save(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        BigDecimal result = submissionRepository.findHigherScoreByChallenge(challengeId);
        if (result != null) {
            return result;
        }
        return BigDecimal.valueOf(0);
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findByChallengeIdAndAcceleration(challengeId, accelerationId);
    }
}
