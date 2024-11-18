package com.artu.keycloak;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String findAll() {
        return "listing products";
    }
    
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String create() {
        return "creating products";
    }
}
