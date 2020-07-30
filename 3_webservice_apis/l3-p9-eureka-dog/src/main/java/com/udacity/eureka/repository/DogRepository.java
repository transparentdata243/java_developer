package com.udacity.eureka.repository;

import com.udacity.eureka.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
