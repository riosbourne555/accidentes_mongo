package com.example.demo.repository.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import com.example.demo.repository.AccidentRepositoryMod;
import com.example.demo.model.PromDistance;
import com.example.demo.model.WConditions;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;

public class AccidentRepositoryImpl implements AccidentRepositoryMod {
    private final MongoTemplate mongoTemp;

    @Autowired
    public AccidentRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemp = mongoTemplate;
    }

    @Override
    public Collection<WConditions> findWConditions() {
        MatchOperation matchOperation = match(new Criteria("Weather_Condition").ne(null));
        GroupOperation groupOperation = group("Weather_Condition").count().as("cantidad");
        SortOperation sortOperation = sort(Sort.Direction.DESC, "cantidad");
        LimitOperation limitTopTen = limit(10);
        Aggregation aggregation = newAggregation(matchOperation, groupOperation, sortOperation, limitTopTen);
        AggregationResults<WConditions> result = mongoTemp.aggregate(aggregation, "accidentes", WConditions.class);
        return result.getMappedResults().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Float findPromDistance() {
        Float promDistance = null;

        MatchOperation matchOperation = match(new Criteria("distance(mi)").ne(null));
        GroupOperation avgOperation = Aggregation.group()
                .avg("distance(mi)")
                .as("avgDistance");
        Aggregation aggregation = newAggregation(matchOperation, avgOperation);
        promDistance = mongoTemp.aggregate(aggregation, "accidentes", PromDistance.class)
                .getUniqueMappedResult()
                .getAvgDistance();

        return promDistance;
    }
}
