package com.challenge.service;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements CandidateServiceInterface {

    @Autowired
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Optional<Candidate> findById(CandidateId id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        return candidateRepository.findByCompany(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return candidateRepository.findByAcceleration(accelerationId);
    }

}
