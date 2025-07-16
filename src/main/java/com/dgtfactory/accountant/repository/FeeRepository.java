package com.dgtfactory.accountant.repository;

import com.dgtfactory.accountant.model.Fee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FeeRepository extends CrudRepository<Fee, UUID> {
}
