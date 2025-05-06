package com.application.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mojib.haider
 * @since 5/4/25
 */
@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
