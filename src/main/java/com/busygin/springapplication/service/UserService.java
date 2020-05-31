package com.busygin.springapplication.service;

import com.busygin.springapplication.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService implements UserServiceInterface {
    private final List<User> users = new ArrayList<>();
    private static final AtomicInteger USER_ID_HOLDER = new AtomicInteger();

    public List<User> getUsers() {
        return this.users;
    }

    public Optional<User> get(final Integer id) {
        return this.users.stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst();
    }

    public User add(final User user) {
        user.setId(USER_ID_HOLDER.incrementAndGet());
        this.users.add(user);
        return user;
    }

    public boolean delete(final Integer id) {
        final Optional<User> userOptional = this.get(id);
        if (userOptional.isPresent()) {
            this.users.remove(userOptional.get());
            return true;
        }
        return false;
    }

    public boolean edit(final Integer id, final User user) {
        final Optional<User> userOptional = this.get(id);
        if (userOptional.isPresent()) {
            userOptional.get().setName(user.getName());
            userOptional.get().setSurname(user.getSurname());
            return true;
        }
        return false;
    }

}
