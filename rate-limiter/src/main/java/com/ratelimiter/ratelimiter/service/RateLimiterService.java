package com.ratelimiter.ratelimiter.service;

import com.ratelimiter.ratelimiter.model.RateLimiterRequest;
import com.ratelimiter.ratelimiter.model.RateLimiterResponse;

public interface RateLimiterService {
    RateLimiterResponse checkForRateLimit(RateLimiterRequest request);
}
