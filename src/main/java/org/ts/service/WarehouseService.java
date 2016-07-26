package org.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ts.model.Warehouse;
import org.ts.repository.WarehouseRepository;

import java.util.List;

@Service
/**
 * Service layer class
 */
public class WarehouseService {
    public static final Integer PAGE_SIZE = 3;
    @Autowired
    WarehouseRepository warehouseRepository;

    /**
     * remove warehouse entity
     *
     * @param id warehouse entity id
     */
    @Transactional
    public void removeWarehouse(Long id) {
        warehouseRepository.delete(id);
    }

    /**
     * find list of products by sellerId
     *
     * @param sellerID
     * @return list of products
     */
    @Transactional
    public List getProductsBySellerID(Long sellerID) {
        return warehouseRepository.getProductsBySellerID(sellerID);
    }

    /**
     * find warehouse entity by
     *
     * @param name product Name and
     * @param Id User Id
     * @return User Entity
     */
    @Transactional
    public Warehouse findByProductNameAndUserId(String name, Long Id) {
        return warehouseRepository.findByProductNameAndSellerId(name, Id);
    }

    /**
     * Save Warehouse entity method
     * @param warehouse
     */
    @Transactional
    public void save(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    /**
     * Find warehouse entity method by
     * @param warehouseID
     * @return Warehouse entity
     */
    @Transactional
    public Warehouse findByID(Long warehouseID) {
        return warehouseRepository.findById(warehouseID);
    }

    /**
     * Find page of Warehouses
     * @param pageNumber
     * @return page of Warehouses
     */
    @Transactional
    public Page<Warehouse> findAll(Integer pageNumber) {
        PageRequest request;
        request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "price");
        return warehouseRepository.findByAmountGreaterThan(0, request);
    }


    /**
     * Find Warehouse entity by
     * @param categoryName
     * @param pageNumber
     * @return page of Warehouse entities
     */
    @Transactional
    public Page<Warehouse> findByCategory(String categoryName, int pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "price");
        return warehouseRepository.findByProductCategoryNameAndAmountGreaterThan(categoryName, 0, request);
    }


    /**
     * Find Warehouse by Name and Mode
     * @param mode
     * @param name
     * @param pageNumber
     * @return page of Warehouse entities
     */
    @Transactional
    public Page<Warehouse> getProductsByModeAndByProductName(String mode, String name, Integer pageNumber) {
        Page<Warehouse> page;
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE/*, Sort.Direction.DESC, "startTime"*/);

        if (mode.equals("ByRating")) {
            page = warehouseRepository.findByProductNameContainingAndOrderByRatingDesc('%' + name + '%', request);
        } else {
            page = warehouseRepository.findByProductNameContainingAndOrderByPriceAsc('%' + name + '%', request);
        }
        return page;
    }


}

