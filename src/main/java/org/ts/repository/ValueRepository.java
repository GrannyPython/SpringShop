package org.ts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.ts.model.Cart;
import org.ts.model.Value;

import java.util.List;

/**
 * Spring Data Jpa-based interface. Thanks Spring, have not implementation at All!
 * Using for realization DAO
 */
public interface ValueRepository extends JpaRepository<Value, Long> {
}
