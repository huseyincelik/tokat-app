package com.n11.repository;

import com.n11.model.Operator;
import org.springframework.data.repository.CrudRepository;

public interface OperatorRepository extends CrudRepository<Operator, Long> {

    Operator findByUsername(String username);

}
