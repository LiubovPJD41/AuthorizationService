package ru.Polyaeva.AuthorizationService.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Polyaeva.AuthorizationService.model.Authorities;
import ru.Polyaeva.AuthorizationService.model.User;
import ru.Polyaeva.AuthorizationService.service.AuthorizationService;


import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }
}
