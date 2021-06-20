package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.Company;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.CandidateRepository;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService implements CompanyServiceInterface {

    @Autowired
    private final CandidateRepository candidateRepository;

    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyService(CandidateRepository candidateRepository, CompanyRepository companyRepository) {
        this.candidateRepository = candidateRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        List<Candidate> allCandidates = (List<Candidate>) candidateRepository.findAll();
        List<Candidate> candidateListByAccelerationId = allCandidates.stream()
                .filter(candidate -> candidate.getId()
                        .getAcceleration().getId().equals(accelerationId))
                .collect(Collectors.toList());
        return candidateListByAccelerationId.stream()
                .map(candidate -> candidate.getId()
                        .getCompany()).distinct().collect(Collectors.toList());
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return companyRepository.findByUserId(userId);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}
