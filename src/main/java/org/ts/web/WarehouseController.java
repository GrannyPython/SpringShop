package org.ts.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.ts.model.*;
import org.ts.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    ParameterService parameterService;
    @Autowired
    ValueService valueService;

    Random random = new Random();

    Logger logger = Logger.getLogger(WarehouseController.class);

    @RequestMapping(value = {"/warehouse"}, method = RequestMethod.GET)
    protected String doGet(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Warehouse> listWarehouse = warehouseService.getProductsBySellerID(user.getId());
        model.addAttribute("warehouseList", listWarehouse);
        return "Warehouse/Warehouse";
    }


    @RequestMapping(value = {"/warehouse/edit/{id}"}, method = RequestMethod.POST)
    protected String doPost(HttpSession session, Model model,
                            @RequestParam("price") float price,
                            @RequestParam("amount") int amount,
                            @RequestParam("description") String description,
                            @PathVariable("id") Long warehouseID) {

        logger.trace("waregouseEdit Method, post request");
        Warehouse product = (Warehouse) warehouseService.findByID(warehouseID);
        product.setAmount(amount);
        product.setPrice(price);
        product.setDescription(description);
        warehouseService.save(product);
        return "redirect:/warehouse";
    }


    @RequestMapping(value = {"/warehouse/edit/{id}"}, method = RequestMethod.GET)
    protected String doGet(Model model, HttpSession session, @PathVariable("id") Long warehouseID) {
        logger.trace("accountUpdate method, get request");
        User user = (User) session.getAttribute("user");
        Warehouse product = warehouseService.findByID(warehouseID);
        model.addAttribute("wh", product);
        return "Warehouse/WarehouseEdit";
    }


    @RequestMapping(value = {"/warehouse/remove/{id}"}, method = RequestMethod.GET)
    protected String doRemove(Model model, HttpSession session, @PathVariable("id") Long warehouseID) {
        logger.trace("remove warehouseNote method, get request");
        warehouseService.removeWarehouse(warehouseID);
        return "redirect:/warehouse";
    }

    @RequestMapping(value = {"/warehouse/addCategory"}, method = RequestMethod.POST)
    protected String addCategoryPost(@ModelAttribute("categoryForm") Category category,
                                     BindingResult bindingResult, Model model) {

        logger.trace("addCategory method, post request");
        logger.info("categoryName" + category.getName());
        categoryService.save(category);

        return "redirect:/";
    }


    @RequestMapping(value = {"/warehouse/addParameter"}, method = RequestMethod.POST)
    protected String addParameterPost(Model model,
                                      @RequestParam("parameterName") String parameterName) {

        logger.trace("addParameter method, post request");
        logger.info("parameterName" + parameterName);

        parameterService.save(new Parameter(parameterName));
        model.addAttribute("message", "Parameter " + parameterName + "was added");
        return "redirect:/warehouse/addCategory";
    }


    @RequestMapping(value = {"/warehouse/addCategory"}, method = RequestMethod.GET)
    protected String addCategoryGet(Model model) {
        logger.trace("addCategory method, get request");
        model.addAttribute("categoryForm", new Category());
        model.addAttribute("parameters", parameterService.findAll());
        return "SellerInterface/addCategory";
    }

    private String saveImage(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        // Creating the directory to store file
        File dir = new File("C:\\Users\\GP\\Desktop\\SpringShop\\src\\main\\webapp\\resources\\tmp\\");
        if (!dir.exists())
            dir.mkdirs();
        // Create the file in resource folder
        String productName = random.nextInt(1000000000) + file.getOriginalFilename();
        File serverFile = new File(dir.getAbsolutePath() + File.separator + productName);
        String staticResource = productName;


        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();

        logger.info("Server File Location="
                + serverFile.getAbsolutePath());
        logger.info("Image was successfully saved");
        return staticResource;
    }

    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("path") String imagePath, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {

        Path path = Paths.get("C:\\Users\\GP\\Desktop\\SpringShop\\src\\main\\webapp\\resources\\tmp\\" + imagePath);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(Files.readAllBytes(path));
        response.getOutputStream().close();
    }


    @RequestMapping(value = {"/warehouse/addProduct"}, method = RequestMethod.GET)
    protected String doGet(Model model) {
        logger.trace("addProduct method, get request");
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);
        model.addAttribute("productForm", new Product());
        return "SellerInterface/addProduct";
    }

    @RequestMapping(value = {"/warehouse/addProduct"}, method = RequestMethod.POST)
    protected String doPost(HttpSession session, Model model, @ModelAttribute("productForm") Product product,
                            @RequestParam("name") String name,
                            @RequestParam("amount") Integer amount,
                            @RequestParam("price") float price,
                            @RequestParam("description") String description) {
        logger.trace("addProduct method, post request");
        product.setName(name);
        if (warehouseService.findByProductNameAndUserId(product.getName(),
                ((User) session.getAttribute("user")).getId()) != null) {
            model.addAttribute("error", "You have it already");
            return "redirect:/warehouse";
        }

        Product pr = productService.findByName(product.getName());
        if (pr != null) {
            Seller seller = (Seller) session.getAttribute("user");
            Warehouse warehouse = new Warehouse();
            warehouse.setPrice(price);
            warehouse.setAmount(amount);
            warehouse.setDescription(description);
            warehouse.setSeller(seller);
            warehouse.setProduct(pr);
            warehouse.setRating("0");
            warehouseService.save(warehouse);
            return "redirect:/warehouse";
        }


        product.setCategory(categoryService.findByName(product.getCategory().getName()));
        session.setAttribute("product", product);
        Warehouse warehouse = new Warehouse();
        warehouse.setAmount(amount);
        warehouse.setPrice(price);
        warehouse.setDescription(description);
        session.setAttribute("warehouse", warehouse);
        model.addAttribute("productForm", product);
        return "SellerInterface/addProductParams";
    }


    @RequestMapping(value = {"/warehouse/addProductParams"}, method = RequestMethod.POST)
    protected String doPost(HttpSession session, Model model,
                            @RequestParam(value = "imageData", required = false) MultipartFile image,
                            @RequestParam(value = "myValues", required = false) String[] myValues,
                            @RequestParam(value = "myParams", required = false) String[] myParams) {

        Product product = null;
        Warehouse warehouse = (Warehouse) session.getAttribute("warehouse");
        if (session.getAttribute("productStatus") == null) {
            product = (Product) session.getAttribute("product");
            logger.trace("addProduct method, post request");

            if (image.isEmpty()) {
                model.addAttribute("error", "Please, choose image");
                return "SellerInterface/addProductParams";
            }

            String pathImage;
            try {
                pathImage = saveImage(image);
            } catch (IOException e) {
                logger.error("You failed to upload image");
                e.printStackTrace();
                model.addAttribute("error", "You cannot save this file");
                return "redirect:/warehouse/addProduct";
            }
            product.setImage(pathImage);
            productService.save(product);
        }

        for (int i = 0; i < myParams.length; i++) {
            Value value = new Value();
            value.setProduct(product);
            value.setParameter(parameterService.findByName(myParams[i]));
            value.setValue(myValues[i]);
            valueService.save(value);
        }

        Seller seller = (Seller) session.getAttribute("user");
        warehouse.setSeller(seller);
        warehouse.setProduct(product);
        warehouse.setRating("0");
        warehouseService.save(warehouse);
        return "redirect:/warehouse";
    }


}
