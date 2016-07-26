package org.ts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.ts.model.Category;

import java.util.List;

/**
 * Spring Data Jpa-based interface. Thanks Spring, have not implementation at All!
 * Using for realization DAO
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * DAO methods
     *
     * @return all Categories like a list
     */
    List<Category> findAll();

    /**
     * DAO methods
     *
     * @param categoryID
     * @return Category object where category id field equals categoryID
     */
    Category findById(Integer categoryID);

    /**
     *
     * @param name Search field
     * @return category object where category name field equals name
     */
    Category findByName(String name);
}
