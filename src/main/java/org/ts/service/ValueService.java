package org.ts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ts.model.User;
import org.ts.model.Value;
import org.ts.repository.UserRepository;
import org.ts.repository.ValueRepository;

@Service
/**
 * Service layer class
 */
public class ValueService {
    @Autowired
    private ValueRepository valueRepository;

    /**
     * save Value object method
     * @param value
     */
    @Transactional
    public void save(Value value) {
        valueRepository.save(value);
    }

}
