package com.masai.Exception;

public class ClaimNotFoundException extends RuntimeException {
    public ClaimNotFoundException(Long id) {
        super("Could not find claim with id " + id);
    }
}
