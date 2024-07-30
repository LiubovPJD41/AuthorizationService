package ru.Polyaeva.AuthorizationService.service;

import org.springframework.stereotype.Service;
import ru.Polyaeva.AuthorizationService.exception.InvalidCredentials;
import ru.Polyaeva.AuthorizationService.exception.UnauthorizedUser;
import ru.Polyaeva.AuthorizationService.model.Authorities;
import ru.Polyaeva.AuthorizationService.model.User;
import ru.Polyaeva.AuthorizationService.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
