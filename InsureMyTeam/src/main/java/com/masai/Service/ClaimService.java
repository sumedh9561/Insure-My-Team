package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.masai.Exception.PolicyNotFoundException;
import com.masai.model.Claim;

public interface ClaimService {
	
    List<Claim> getAllClaims() throws PolicyNotFoundException;

    Optional<Claim> getClaimById(Long id) throws PolicyNotFoundException;

    Claim createClaim(Claim claim) ;

    void updateClaim(Long id, Claim claim)throws PolicyNotFoundException;

    void deleteClaim(Long id)throws PolicyNotFoundException;
}
