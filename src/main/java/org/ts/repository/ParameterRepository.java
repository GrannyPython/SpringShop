package org.ts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ts.model.Category;
import org.ts.model.Parameter;


/**
 * Spring Data Jpa-based interface. Thanks Spring, have not implementation at All!
 * Using for realization DAO
 */

public interface ParameterRepository extends JpaRepository<Parameter, Long> {
    /**
     * DAO Method
     * Find Parameter object By Name
     * @param name Parameter Name
     * @return Parameter object
     */
    Parameter findByName(String name);

}
