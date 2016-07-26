package org.ts.repository;

import org.ts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data Jpa-based interface. Thanks Spring, have not implementation at All!
 * Using for realization DAO
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * DAO Method
     * Find User object bt userId field
     * @param id User Id in DB
     * @return User Entity
     */
    User findById(Long id);

    /**DAO Method
     * Find User By email
     * @param email User field "Email"
     * @return User Entity
     */
    User findByEmail(String email);

    /**DAO Method
     * Find User by
     * @param email and
     * @param password
     * @return User Entit
     */
    User findByEmailAndPassword(String email, String password);

}
