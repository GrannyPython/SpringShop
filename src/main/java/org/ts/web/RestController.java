package org.ts.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ts.model.Product;
import org.ts.service.ProductService;

import java.util.List;

/**
 * Class working with second application via REST service.
 * It provide some king of stats data about application
 *
 * @author GP
 */

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    ProductService warehouseService;

    Logger logger = Logger.getLogger(RestController.class);


    /**
     * It using Spring Data Jpa and
     *
     * @return generates list of the most popular products
     */
    @RequestMapping(value = "/statistics", method = RequestMethod.GET, produces = "application/json")
    public List<Product> greeting() {
        logger.trace("statistics Rest method, get Request");
        List<Product> list = warehouseService.getPopularProducts();
        return list;
    }

}
