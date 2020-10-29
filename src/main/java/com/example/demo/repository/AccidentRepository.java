package com.example.demo.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.model.Accident;


@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> , AccidentRepositoryMod{

    List<Accident> findByStartLocationNear(Point point, Distance distance, Pageable pageable);

     List<Accident> findByStartTimeBetween(String fecha1, String fecha2, Pageable pageable);

}
