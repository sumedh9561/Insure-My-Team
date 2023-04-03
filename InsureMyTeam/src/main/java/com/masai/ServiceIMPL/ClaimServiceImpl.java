package com.masai.ServiceIMPL;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.PolicyNotFoundException;
import com.masai.model.Claim;
import com.masai.Repository.ClaimRepository;
import com.masai.Service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;

	@Override
	public List<Claim> getAllClaims() throws PolicyNotFoundException {
		List<Claim> claims = claimRepository.findAll();
		if (claims.isEmpty()) {
			throw new PolicyNotFoundException("No claims found in the system");
		}
		return claims;
	}

	@Override
	public Optional<Claim> getClaimById(Long id) throws PolicyNotFoundException {
		Optional<Claim> claim = claimRepository.findById(id);
		if (!claim.isPresent()) {
			throw new PolicyNotFoundException("Claim not found with id " + id);
		}
		return claim;
	}

	@Override
	public Claim createClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	@Override
	public void updateClaim(Long id, Claim claim) throws PolicyNotFoundException {
		Optional<Claim> optionalClaim = claimRepository.findById(id);
		if (!optionalClaim.isPresent()) {
			throw new PolicyNotFoundException("Claim not found with id " + id);
		}
		claim.setId(id);
		claimRepository.save(claim);
	}

	@Override
	public void deleteClaim(Long id) throws PolicyNotFoundException {
		Optional<Claim> optionalClaim = claimRepository.findById(id);
		if (!optionalClaim.isPresent()) {
			throw new PolicyNotFoundException("Claim not found with id " + id);
		}
		claimRepository.deleteById(id);
	}
}
