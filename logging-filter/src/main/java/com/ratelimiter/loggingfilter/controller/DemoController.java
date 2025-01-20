package com.ratelimiter.loggingfilter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")

//Note : not working properly.
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, World!");
    }

    @PostMapping("/echo")
    public ResponseEntity<String> echoMessage(@RequestBody String message) {
        return ResponseEntity.ok("Received: " + message);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateResource(@PathVariable Long id, @RequestBody String data) {
        return ResponseEntity.ok("Resource with ID " + id + " updated with data: " + data);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
        return ResponseEntity.ok("Resource with ID " + id + " deleted successfully!");
    }
}
