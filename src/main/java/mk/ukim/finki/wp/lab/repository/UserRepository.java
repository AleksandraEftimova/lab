package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.User;

import java.util.Optional;

public class UserRepository {

    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream()
                .filter(r->r.getUsername().equals(username))
                .findFirst();
    }

    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return DataHolder.users.stream()
                .filter(r->r.getUsername().equals(username) && r.getPassword().equals(password))
                .findFirst();
    }

    public User save(User user) {
        DataHolder.users.removeIf(r->r.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    public void delete(String username) {
        DataHolder.users.removeIf(r->r.getUsername().equals(username));
    }
}