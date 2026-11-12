package com.spring.spring_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * REST controller providing a basic test endpoint.
 */
@RestController 
@RequestMapping("/test")
public class DemoRestController {

    /**
     * Returns a greeting message to verify the REST endpoint is active.
     *
     * @return a {@code "Hello World!"} greeting string
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
    
}