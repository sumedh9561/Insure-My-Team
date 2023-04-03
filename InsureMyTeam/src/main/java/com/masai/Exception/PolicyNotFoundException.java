package com.masai.Exception;

public class PolicyNotFoundException extends RuntimeException {
    public PolicyNotFoundException(String string) {
        super("Could not find policy with id " + string);
    }
}

