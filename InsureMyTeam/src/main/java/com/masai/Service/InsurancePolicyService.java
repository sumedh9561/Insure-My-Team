package com.masai.Service;

import java.util.List;
import java.util.Optional;

import com.masai.Exception.PolicyNotFoundException;
import com.masai.model.InsurancePolicy;

public interface InsurancePolicyService {
    List<InsurancePolicy> getAllInsurancePolicies() throws PolicyNotFoundException;

    Optional<InsurancePolicy> getInsurancePolicyById(Long id) throws PolicyNotFoundException;

    InsurancePolicy createInsurancePolicy(InsurancePolicy policy);

    void updateInsurancePolicy(Long id, InsurancePolicy policy) throws PolicyNotFoundException;

    void deleteInsurancePolicy(Long id) throws PolicyNotFoundException;
}
