package com.ratelimiter.ratelimiter.controller;

import com.ratelimiter.ratelimiter.constant.URLConstant;
import com.ratelimiter.ratelimiter.model.RateLimiterRequest;
import com.ratelimiter.ratelimiter.model.RateLimiterResponse;
import com.ratelimiter.ratelimiter.service.RateLimiterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// /ratelimiter
@RestController
@RequestMapping(URLConstant.CONTEXT_PATH)
public class RateLimiterController {

    private final RateLimiterService rateLimiterService;

    public RateLimiterController(RateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService;
    }

    ///checkServices
    @PostMapping(URLConstant.CHECK_SERVICES)
    public RateLimiterResponse checkServices(@RequestBody RateLimiterRequest request){
        return rateLimiterService.checkForRateLimit(request);

    }
}
