package com.ratelimiter.ratelimiter.service.impl;

import com.ratelimiter.ratelimiter.core.RateLimiter;
import com.ratelimiter.ratelimiter.core.TokenBucketAlgorithm;
import com.ratelimiter.ratelimiter.model.RateLimiterRequest;
import com.ratelimiter.ratelimiter.model.RateLimiterResponse;
import com.ratelimiter.ratelimiter.service.RateLimiterService;
import org.springframework.stereotype.Service;

@Service
public class RateLimiterServiceImpl implements RateLimiterService {


    @Override
    public RateLimiterResponse checkForRateLimit(RateLimiterRequest request) {
        System.out.println("Message : " + request.getMessage());

        RateLimiter rateLimiter = new RateLimiter(new TokenBucketAlgorithm(1, 60*6));
        RateLimiterResponse rateLimiterResponse = new RateLimiterResponse();
        if(rateLimiter.allowRequest()){
            rateLimiterResponse.setMessage("SUCCESS");
            rateLimiterResponse.setUserId(request.getUserId());
            return rateLimiterResponse;
        }

       rateLimiterResponse.setMessage("Request dropped !!");
        rateLimiterResponse.setUserId(request.getUserId());
        return rateLimiterResponse;
    }
}
