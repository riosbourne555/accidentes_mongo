package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Accident;

@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> {

}
