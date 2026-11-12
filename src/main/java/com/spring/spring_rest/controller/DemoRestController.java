package com.spring.spring_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * REST controller providing basic health-check and demonstration endpoints
 * mapped under the {@code /test} base path.
 */
@RestController 
@RequestMapping ("/test")
public class DemoRestController {

    @GetMapping ("/hello")
    public String sayHello() {
        return "Hello World!";
    }

}
