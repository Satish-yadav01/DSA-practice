package com.ratelimiter.ratelimiter.core;

import org.springframework.stereotype.Service;


public abstract class AbstractAlgorithm {
    protected int limit;
    protected int timePeriod;

    public AbstractAlgorithm(int limit, int timePeriod) {
        this.limit = limit;
        this.timePeriod = timePeriod;
    }

    public abstract boolean allowRequest();
}
