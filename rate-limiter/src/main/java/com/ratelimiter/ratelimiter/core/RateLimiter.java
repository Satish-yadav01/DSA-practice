package com.ratelimiter.ratelimiter.core;

import org.springframework.stereotype.Service;


public class RateLimiter {
    private AbstractAlgorithm algorithm;

    public RateLimiter(AbstractAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public boolean allowRequest(){
        return algorithm.allowRequest();
    }

    public void setAlgorithm(AbstractAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
}
