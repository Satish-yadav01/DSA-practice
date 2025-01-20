package com.ratelimiter.ratelimiter.core;

import org.springframework.stereotype.Service;


public class TokenBucketAlgorithm extends AbstractAlgorithm {
    private int tokens;
    private long lastRefillTime;

    public TokenBucketAlgorithm(int limit, int timePeriod) {
        super(limit, timePeriod);
        this.tokens = limit; // Initialize with full tokens
        this.lastRefillTime = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();

        //refill the token based on elapse time
        long elapsedTime = currentTime - lastRefillTime;
        int tokensToAdd = (int) (elapsedTime * limit / timePeriod);

        if (tokensToAdd > 0) {
            tokens = Math.min(limit, tokens + tokensToAdd);
            lastRefillTime = currentTime;
        }

        if (tokens > 0) {
            // Consume a token
            tokens--;
            return true;
        }

        return false; // Reject request

    }
}
