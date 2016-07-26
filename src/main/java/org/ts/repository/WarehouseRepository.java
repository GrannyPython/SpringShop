package org.ts.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.ts.model.Warehouse;
import java.util.List;

/**
 * Spring Data Jpa-based interface. Thanks Spring, have not implementation at All!
 * Using for realization DAO
 */
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

    /**
     * DAO Method
     * Find Warehouses by
     * @param sellerID
     * @return list of Warehouse entities
     */
    @Query("SELECT w FROM Warehouse w where w.seller.id = ?1")
    List getProductsBySellerID(Long sellerID);

    /**
     * DAO Method
     * Find warehouse by warehouse Id
     * @param Id
     * @return warehouse List
     */
    Warehouse findById(Long Id);

    /**
     * DAO Method
     * Find warehouse by
     * @param name product name and
     * @param id sellerID
     * @return warehouse note
     */
    Warehouse findByProductNameAndSellerId(String name, Long id);

    /**
     * DAO Method
     * find warehouse Page by
     * @param category name of Category and
     * @param x minimal value of products
     * @param request infrormational pparameter with page number and etc
     * @return find warehouse page by

     */
    Page<Warehouse> findByProductCategoryNameAndAmountGreaterThan(String category, int x, Pageable request);

    /**
     * DAO Method
     * find warehouse page by
     * @param x min value of product
     * @param pageRequest Spring Data paging parameter, contains number of page
     * @return Page collection of warehouse entities
     */
    Page<Warehouse> findByAmountGreaterThan(int x, Pageable pageRequest);

    /**
     * DAO Method
     * find warehouse page by
     * @param name product name and
     * @param request Spring Data paging parameter, contains number of page
     * @return Page collection of warehouse entities
     */
    @Query("SELECT w from Warehouse w join w.product p where p.name like ?1 AND w.amount > 0 order by w.rating desc ")
    Page<Warehouse> findByProductNameContainingAndOrderByRatingDesc(String name, Pageable request);

    /**
     * DAO Method
     * find waregouse, where name variable contains
     * @param name product name
     * @param request Spring Data paging parameter, contains number of page
     * @return Page collection of warehouse entities
     */
    @Query("SELECT w from Warehouse w join w.product p where p.name like ?1 AND w.amount > 0 order by w.price asc ")
    Page<Warehouse> findByProductNameContainingAndOrderByPriceAsc(String name, Pageable request);

}