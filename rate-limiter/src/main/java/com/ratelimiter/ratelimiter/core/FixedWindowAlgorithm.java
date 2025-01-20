package com.ratelimiter.ratelimiter.core;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class FixedWindowAlgorithm extends AbstractAlgorithm{
    private final Map<Long, Integer> requestCounts = new ConcurrentHashMap<>();

    public FixedWindowAlgorithm(int limit, int timePeriod) {
        super(limit, timePeriod);
    }

    @Override
    public synchronized boolean allowRequest() {
        long currentWindow = System.currentTimeMillis() / timePeriod;
        requestCounts.putIfAbsent(currentWindow, 0);

        if(requestCounts.get(currentWindow) >= limit) {
            requestCounts.put(currentWindow, requestCounts.get(currentWindow) + 1);
            return true;
        }

        return false;
    }
}
