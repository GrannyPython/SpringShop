package org.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ts.model.Category;
import org.ts.model.Parameter;
import org.ts.repository.CategoryRepository;
import org.ts.repository.ParameterRepository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Service layer class
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ParameterRepository parameterRepository;
    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Transactional
    public Category findByID(Integer categoryID) {
        return categoryRepository.findById(categoryID);
    }


    /**
     * Save category, where
     * @param name category Name
     * @param parameters List of parameters
     */
    @Transactional
    public void save(String name, List<String> parameters) {
        Category category = categoryRepository.findByName(name);
        if(category==null) {
            category = new Category(name);
        }
        Set<String> set = new HashSet(parameters);
        Set<Parameter> lp = new HashSet<>();
        for (String parName : set) {
            Parameter parameter = parameterRepository.findByName(parName);
            if(parameter==null){
                parameter = new Parameter(parName);
            }
            lp.add(parameter);
        }
        category.setParameters(lp);
        categoryRepository.save(category);
    }


    /**
     * Save category by category name
     * @param category
     * @return category entity with ID variable
     */
    @Transactional
    public Category save(Category category) {
        Set<Parameter> set = new HashSet<>();
        for (Parameter parameter : category.getParameters()) {
            String name = parameter.getName().trim();
            set.add(parameterRepository.findByName(name));
        }
        category.getParameters().clear();
        category.setParameters(set);
        return categoryRepository.save(category);
    }


    /**
     *find category by ID
     * @param name
     * @return Category entity
     */
    @Transactional
    public Category findByName(String name) {return categoryRepository.findByName(name);}
}
