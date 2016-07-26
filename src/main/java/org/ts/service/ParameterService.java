package org.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ts.model.*;
import org.ts.repository.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
/**
 * Service layer class
 */
public class ParameterService {
    @Autowired
    ParameterRepository parameterRepository;

    /**
     * Boilerplate save method
     * @param parameter
     * @return parameter entity with ID
     */
    public Parameter save(Parameter parameter){return parameterRepository.save(parameter);}

    /**
     * Find all parameters in Table parameters
     * @return set of parameters
     */
    public Set<Parameter> findAll(){return new HashSet<>(parameterRepository.findAll());}

    /**
     * find parameter by name
     * @param name
     * @return Parameter entity
     */
    public Parameter findByName(String name) {return  parameterRepository.findByName(name);}
}
