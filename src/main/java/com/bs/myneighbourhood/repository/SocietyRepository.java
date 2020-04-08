package com.bs.myneighbourhood.repository;

import com.bs.myneighbourhood.document.SocietyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocietyRepository extends MongoRepository<SocietyDocument,Integer> {
}
