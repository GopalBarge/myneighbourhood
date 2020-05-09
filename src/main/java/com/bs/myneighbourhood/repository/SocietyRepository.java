package com.bs.myneighbourhood.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.bs.myneighbourhood.dto.Society;
import com.bs.myneighbourhood.entity.SocietyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class SocietyRepository {

    @Autowired
    DynamoDBMapper dynamoDBMapper;

    public SocietyDocument getSocietyDetails(String city, String name) {
        return dynamoDBMapper.load(SocietyDocument.class, city, name);
    }

    public List<SocietyDocument> getAllSocietyDetails() {
        PaginatedScanList<SocietyDocument> result = dynamoDBMapper.scan(SocietyDocument.class, new DynamoDBScanExpression());
        return result.parallelStream().collect(Collectors.toList());
    }

    public SocietyDocument getSocietyById(Integer societyId) {

        DynamoDBQueryExpression<SocietyDocument> dbQuery = new DynamoDBQueryExpression();
        Map<String, AttributeValue> searchPeram = new HashMap<String, AttributeValue>();
        searchPeram.put(":id", new AttributeValue().withN(societyId.toString()));
        dbQuery.withExpressionAttributeValues(searchPeram);
        List<SocietyDocument> result = dynamoDBMapper.query(SocietyDocument.class, dbQuery);
        return result.size()>0?result.get(0):new SocietyDocument();
    }

    public void addSociety(SocietyDocument toEntity) {
       dynamoDBMapper.save(toEntity);
    }

    public void updateSociety(SocietyDocument toEntity) {
        DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
                .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
                .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE)
                .build();
        dynamoDBMapper.save(toEntity, dynamoDBMapperConfig);
    }
}
