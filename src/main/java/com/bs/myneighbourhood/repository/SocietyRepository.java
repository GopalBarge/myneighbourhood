
package com.bs.myneighbourhood.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bs.myneighbourhood.dynamodb.model.SocietyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//
//import com.bs.myneighbourhood.document.SocietyDocument;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
@Repository
public class SocietyRepository  {
    @Autowired
    private DynamoDBMapper dbMapper;

   public  Optional<SocietyDocument> load(String name,String city) {

        return Optional.ofNullable(dbMapper.load(SocietyDocument.class, name,city));
    }

    public void save(SocietyDocument society){
        dbMapper.save(society);
    }
}
