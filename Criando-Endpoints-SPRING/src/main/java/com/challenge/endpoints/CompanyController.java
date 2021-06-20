package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{companyId}")
    public Optional<Company> findById(@PathVariable("companyId") Long companyId){
        return this.companyService.findById(companyId);
    }

    @GetMapping
    List<Company> findAllByAccelerationIdOrUserId(
            @RequestParam(required = false) Long accelerationId,
            @RequestParam(required = false) Long userId) {
        if (accelerationId != null) return this.companyService.findByAccelerationId(accelerationId);
        return this.companyService.findByUserId(userId);
    }
}
