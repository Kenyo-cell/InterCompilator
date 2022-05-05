package ru.mirea.service;

import org.springframework.stereotype.Service;
import ru.mirea.entity.UserEntity;
import ru.mirea.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity saveUser(UserEntity user) {
        return null;
    }

    public UserEntity updateUser(UserEntity user) {
        return null;
    }

    public long deleteUser(long id) {
        return 0;
    }

    public UserEntity getUserById(long id) {
        return null;
    }
}
