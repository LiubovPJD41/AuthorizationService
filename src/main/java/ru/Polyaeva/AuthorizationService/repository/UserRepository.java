package ru.Polyaeva.AuthorizationService.repository;

import org.springframework.stereotype.Repository;
import ru.Polyaeva.AuthorizationService.model.Authorities;
import ru.Polyaeva.AuthorizationService.model.User;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<String, User> usersList = new HashMap<>();

    public UserRepository() {
        User user1 = new User("Ivanova", "xxx", Arrays.asList(Authorities.READ));
        usersList.put(user1.getUser(), user1);
        User user2 = new User("Petrov", "12345", Arrays.asList(Authorities.READ, Authorities.WRITE));
        usersList.put(user2.getUser(), user2);
        User user3 = new User("Sidorov", "54321", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        usersList.put(user3.getUser(), user3);
    }

    public List<Authorities> getUserAuthorities(User user) {
        User userToBeFound = usersList.get(user.getUser());
        return (userToBeFound == null || !userToBeFound.getPassword().equals(user.getPassword())) ? Collections.emptyList() : userToBeFound.getAuthorities();
    }
}