package com.masai.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.Exception.PolicyNotFoundException;
import com.masai.model.InsurancePolicy;
import com.masai.Service.InsurancePolicyService;

@RestController
@RequestMapping("/policies")
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyService policyService;

    @GetMapping
    public ResponseEntity<List<InsurancePolicy>> getAllInsurancePolicies() throws PolicyNotFoundException {
        List<InsurancePolicy> policies = policyService.getAllInsurancePolicies();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable Long id) throws PolicyNotFoundException {
        Optional<InsurancePolicy> policy = policyService.getInsurancePolicyById(id);
        if (policy.isPresent()) {
            return new ResponseEntity<>(policy.get(), HttpStatus.OK);
        } else {
            throw new PolicyNotFoundException("Policy not found with id " + id);
        }
    }

    @PostMapping
    public ResponseEntity<InsurancePolicy> createInsurancePolicy(@RequestBody InsurancePolicy policy) {
        InsurancePolicy createdPolicy = policyService.createInsurancePolicy(policy);
        return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInsurancePolicy(@PathVariable Long id, @RequestBody InsurancePolicy policy) throws PolicyNotFoundException {
        policyService.updateInsurancePolicy(id, policy);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurancePolicy(@PathVariable Long id) throws PolicyNotFoundException {
        policyService.deleteInsurancePolicy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
