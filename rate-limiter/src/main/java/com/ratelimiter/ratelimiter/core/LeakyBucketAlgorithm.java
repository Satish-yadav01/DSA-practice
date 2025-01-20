package com.ratelimiter.ratelimiter.core;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;


public class LeakyBucketAlgorithm extends AbstractAlgorithm{
    private final Queue<Long> bucket = new LinkedList<>();
    private final long leakRate; // Time interval for leaking one request


    public LeakyBucketAlgorithm(int limit, int timePeriod) {
        super(limit, timePeriod);
        this.leakRate = timePeriod/limit; // Leak one request every interval
    }

    @Override
    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();

        // Leak requests based on elapsed time
        while (!bucket.isEmpty() && bucket.peek() < currentTime - leakRate) {
            bucket.poll();
        }

        if (bucket.size() < limit) {
            // Allow request and add current timestamp
            bucket.add(currentTime);
            return true;
        }

        return false;
    }
}
