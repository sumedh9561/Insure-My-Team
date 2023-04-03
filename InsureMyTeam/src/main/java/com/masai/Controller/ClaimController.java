package com.masai.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.Exception.PolicyNotFoundException;
import com.masai.Service.ClaimService;
import com.masai.model.Claim;

@RestController
@RequestMapping("/api/v1/claims")
public class ClaimController {

	@Autowired
	private ClaimService claimService;

	@GetMapping
	public ResponseEntity<List<Claim>> getAllClaims() throws PolicyNotFoundException {
		List<Claim> claims = claimService.getAllClaims();
		return new ResponseEntity<List<Claim>>(claims, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable("id") Long id) throws PolicyNotFoundException {
		Optional<Claim> optionalClaim = claimService.getClaimById(id);
		return new ResponseEntity<Claim>(optionalClaim.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
		Claim savedClaim = claimService.createClaim(claim);
		return new ResponseEntity<Claim>(savedClaim, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Claim> updateClaim(@PathVariable("id") Long id, @RequestBody Claim claim) throws PolicyNotFoundException {
		claimService.updateClaim(id, claim);
		return new ResponseEntity<Claim>(claim, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteClaim(@PathVariable("id") Long id) throws PolicyNotFoundException {
		claimService.deleteClaim(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
