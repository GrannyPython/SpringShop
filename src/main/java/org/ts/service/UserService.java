package org.ts.service;

import org.springframework.transaction.annotation.Transactional;
import org.ts.model.User;
import org.ts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
/**
 * Service layer class
 */
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * boilerplate save method
     * @param user
     */
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * Find User By email
     * @param email user email
     * @return User entity
     */
    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Find user by password and email
     * @param email
     * @param password
     * @return user object
     */
    @Transactional
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
