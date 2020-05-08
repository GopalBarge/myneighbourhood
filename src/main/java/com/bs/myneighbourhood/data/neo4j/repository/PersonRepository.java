package com.bs.myneighbourhood.data.neo4j.repository;

import com.bs.myneighbourhood.core.domain.entities.Person;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Set;

public interface PersonRepository extends Neo4jRepository<Person,String> {
    PersonRepository.Companion Companion = PersonRepository.Companion.$$INSTANCE;
    @NotNull
    String FIND_BY_FIRSTNAME_WITH_SIBLINGS = "MATCH (person:Person {firstname: {firstname}})\n                        WITH person\n                        OPTIONAL MATCH (person)-[:HAS_MOTHER]->(mother)\n                        OPTIONAL MATCH (person)-[:HAS_FATHER]->(father)\n                        OPTIONAL MATCH (person)-[:SPOUSE_OF]-(spouse)\n                        OPTIONAL MATCH (person)-[:HAS_MOTHER|HAS_FATHER]->(Parent)<-[:HAS_MOTHER|HAS_FATHER]-(siblings)\n                        RETURN person, spouse, mother, father, collect(distinct siblings) as siblings";
    @NotNull
    String FIND_SIBLINGS = "MATCH (person:Person {uuid: {0}})\n                                     WITH person\n                                     MATCH (person)-[:HAS_MOTHER|HAS_FATHER]->(Parent)<-[:HAS_MOTHER|HAS_FATHER]-(siblings)\n                                     RETURN distinct siblings\n                                  ";
    @NotNull
    String FIND_SPOUSE = "MATCH (:Person {uuid: {0}})-[:SPOUSE_OF]-(spouse)\n                                   RETURN spouse\n                                ";
    @NotNull
    String FIND_MOTHER = "MATCH (:Person {uuid: {0}})-[:HAS_MOTHER]->(mother)\n                                   RETURN mother\n                                ";
    @NotNull
    String FIND_FATHER = "MATCH (:Person {uuid: {0}})-[:HAS_FATHER]->(father)\n                                   RETURN father\n                                ";
    @NotNull
    String FIND_FRIENDS = "MATCH (:Person {uuid: {0}})-[:FRIEND_OF]-(friends)\n                                    RETURN friends\n                                ";

    @Query("MATCH (person:Person {firstname: {firstname}}) RETURN person")
    @NotNull
    Collection findByFirstname(@Param("firstname") @NotNull String var1);

    @Query("MATCH (person:Person {lastname: {lastname}}) RETURN person")
    @NotNull
    Collection findByLastname(@Param("lastname") @NotNull String var1);

    @Query("MATCH (person:Person {uuid: {uuid}}) RETURN person")
    @Nullable
    Person findByUuid(@Param("uuid") @NotNull String var1);

    @Query("MATCH (person:Person {uuid: {0}})\n                                     WITH person\n                                     MATCH (person)-[:HAS_MOTHER|HAS_FATHER]->(Parent)<-[:HAS_MOTHER|HAS_FATHER]-(siblings)\n                                     RETURN distinct siblings\n                                  ")
    @NotNull
    Set findSiblingsOf(@Param("uuid") @NotNull String var1);

    @Query("MATCH (:Person {uuid: {0}})-[:SPOUSE_OF]-(spouse)\n                                   RETURN spouse\n                                ")
    @Nullable
    Person findSpouseOf(@Param("uuid") @NotNull String var1);

    @Query("MATCH (:Person {uuid: {0}})-[:HAS_MOTHER]->(mother)\n                                   RETURN mother\n                                ")
    @Nullable
    Person findMotherOf(@Param("uuid") @NotNull String var1);

    @Query("MATCH (:Person {uuid: {0}})-[:HAS_FATHER]->(father)\n                                   RETURN father\n                                ")
    @Nullable
    Person findFatherOf(@Param("uuid") @NotNull String var1);

    @Query("MATCH (:Person {uuid: {0}})-[:FRIEND_OF]-(friends)\n                                    RETURN friends\n                                ")
    @NotNull
    Set findFriendsOf(@Param("uuid") @NotNull String var1);

    public static final class Companion {
        @NotNull
        public static final String FIND_BY_FIRSTNAME_WITH_SIBLINGS = "MATCH (person:Person {firstname: {firstname}})\n                        WITH person\n                        OPTIONAL MATCH (person)-[:HAS_MOTHER]->(mother)\n                        OPTIONAL MATCH (person)-[:HAS_FATHER]->(father)\n                        OPTIONAL MATCH (person)-[:SPOUSE_OF]-(spouse)\n                        OPTIONAL MATCH (person)-[:HAS_MOTHER|HAS_FATHER]->(Parent)<-[:HAS_MOTHER|HAS_FATHER]-(siblings)\n                        RETURN person, spouse, mother, father, collect(distinct siblings) as siblings";
        @NotNull
        public static final String FIND_SIBLINGS = "MATCH (person:Person {uuid: {0}})\n                                     WITH person\n                                     MATCH (person)-[:HAS_MOTHER|HAS_FATHER]->(Parent)<-[:HAS_MOTHER|HAS_FATHER]-(siblings)\n                                     RETURN distinct siblings\n                                  ";
        @NotNull
        public static final String FIND_SPOUSE = "MATCH (:Person {uuid: {0}})-[:SPOUSE_OF]-(spouse)\n                                   RETURN spouse\n                                ";
        @NotNull
        public static final String FIND_MOTHER = "MATCH (:Person {uuid: {0}})-[:HAS_MOTHER]->(mother)\n                                   RETURN mother\n                                ";
        @NotNull
        public static final String FIND_FATHER = "MATCH (:Person {uuid: {0}})-[:HAS_FATHER]->(father)\n                                   RETURN father\n                                ";
        @NotNull
        public static final String FIND_FRIENDS = "MATCH (:Person {uuid: {0}})-[:FRIEND_OF]-(friends)\n                                    RETURN friends\n                                ";
        // $FF: synthetic field
        static final PersonRepository.Companion $$INSTANCE;

        private Companion() {
        }

        static {
            PersonRepository.Companion var0 = new PersonRepository.Companion();
            $$INSTANCE = var0;
        }
    }
}
