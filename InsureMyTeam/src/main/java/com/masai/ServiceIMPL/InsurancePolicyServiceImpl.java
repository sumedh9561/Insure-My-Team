package com.masai.ServiceIMPL;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.PolicyNotFoundException;
import com.masai.model.InsurancePolicy;
import com.masai.Repository.InsurancePolicyRepository;
import com.masai.Service.InsurancePolicyService;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

	@Autowired
	private InsurancePolicyRepository policyRepository;

	@Override
	public List<InsurancePolicy> getAllInsurancePolicies() throws PolicyNotFoundException {
		List<InsurancePolicy> policies = policyRepository.findAll();
		if (policies.isEmpty()) {
			throw new PolicyNotFoundException("No policies found in the system");
		}
		return policies;
	}

	@Override
	public Optional<InsurancePolicy> getInsurancePolicyById(Long id) throws PolicyNotFoundException {
		Optional<InsurancePolicy> policy = policyRepository.findById(id);
		if (!policy.isPresent()) {
			throw new PolicyNotFoundException("Policy not found with id " + id);
		}
		return policy;
	}

	@Override
	public InsurancePolicy createInsurancePolicy(InsurancePolicy policy) {
		return policyRepository.save(policy);
	}

	@Override
	public void updateInsurancePolicy(Long id, InsurancePolicy policy) throws PolicyNotFoundException {
		Optional<InsurancePolicy> optionalPolicy = policyRepository.findById(id);
		if (!optionalPolicy.isPresent()) {
			throw new PolicyNotFoundException("Policy not found with id " + id);
		}
		policy.setId(id);
		policyRepository.save(policy);
	}

	@Override
	public void deleteInsurancePolicy(Long id) throws PolicyNotFoundException {
		Optional<InsurancePolicy> optionalPolicy = policyRepository.findById(id);
		if (!optionalPolicy.isPresent()) {
			throw new PolicyNotFoundException("Policy not found with id " + id);
		}
		policyRepository.deleteById(id);
	}
}

