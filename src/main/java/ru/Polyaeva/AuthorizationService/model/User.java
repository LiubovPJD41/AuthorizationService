package ru.Polyaeva.AuthorizationService.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

public class User {
    @NotBlank
    @Size(min = 2)
    @Size(max = 15)
    private final String user;
    @NotBlank

    @Size(min = 2)
    @Size(max = 20)
    private final String password;

    private final List<Authorities> authorities;

    public User(String user, String password, List<Authorities> authorities) {
        this.user = user;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user1)) return false;
        return user.equals(user1.user) && password.equals(user1.password) && authorities.equals(user1.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    @Override
    public String toString() {
        return "User " + user + " (password: " + password + ")";
    }
}