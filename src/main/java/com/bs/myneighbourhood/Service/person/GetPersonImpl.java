package com.bs.myneighbourhood.Service.person;

import com.bs.myneighbourhood.api.dto.PersonDTO;
import com.bs.myneighbourhood.core.domain.entities.Person;
import com.bs.myneighbourhood.data.neo4j.repository.PersonRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class GetPersonImpl implements GetPerson {
    @NotNull
    private final PersonRepository personRepository;

    public GetPersonImpl(@NotNull PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Nullable
    @Override
    public PersonDTO byUuid(@NotNull String var1) {
        return null;
    }

    @NotNull
    @Override
    public Collection byFirstname(@NotNull String var1) {
        return null;
    }

    @NotNull
    @Override
    public Collection byLastname(@NotNull String var1) {
        return null;
    }

    @NotNull
    @Override
    public Collection all(@Nullable Integer var1) {
        Iterable<Person> persons = personRepository.findAll();
        List<Person> list = new ArrayList<>();
        persons.forEach(person -> list.add(person));
        return list;
    }

    @NotNull
    @Override
    public Collection siblings(@NotNull String var1) {
        return null;
    }

    @NotNull
    @Override
    public Collection friends(@NotNull String var1) {
        return null;
    }

    @Nullable
    @Override
    public PersonDTO mother(@NotNull String var1) {
        return null;
    }

    @Nullable
    @Override
    public PersonDTO father(@NotNull String var1) {
        return null;
    }

    @Nullable
    @Override
    public PersonDTO spouse(@NotNull String var1) {
        return null;
    }

/*    @Nullable
    public PersonDTO mother(@NotNull String uuid) {
        Intrinsics.checkParameterIsNotNull(uuid, "uuid");
        Person var10000 = this.getPersonRepository().findMotherOf(uuid);
        return var10000 != null ? var10000.toPersonDTO() : null;
    }*/

 /*   @Nullable
    public PersonDTO father(@NotNull String uuid) {
        Intrinsics.checkParameterIsNotNull(uuid, "uuid");
        Person var10000 = this.getPersonRepository().findFatherOf(uuid);
        return var10000 != null ? var10000.toPersonDTO() : null;
    }*/
/*
    @Nullable
    public PersonDTO spouse(@NotNull String uuid) {
        Intrinsics.checkParameterIsNotNull(uuid, "uuid");
        Person var10000 = this.getPersonRepository().findSpouseOf(uuid);
        return var10000 != null ? var10000.toPersonDTO() : null;
    }*/

  /*  @NotNull
    public List siblings(@NotNull String uuid) {
        Iterable $this$map$iv = (Iterable) this.getPersonRepository().findSiblingsOf(uuid);
        boolean $i$f$map = false;
        Collection destination$iv$iv = (Collection) (new ArrayList());
        boolean $i$f$mapTo = false;
        Iterator var7 = $this$map$iv.iterator();

        while (var7.hasNext()) {
            Object item$iv$iv = var7.next();
            Person it = (Person) item$iv$iv;
            boolean var10 = false;
            PersonDTO var12 = it.toPersonDTO();
            destination$iv$iv.add(var12);
        }

        return (List) destination$iv$iv;
    }
*/

  /*  @NotNull
    public List friends(@NotNull String uuid) {
        Iterable $this$map$iv = (Iterable) this.getPersonRepository().findFriendsOf(uuid);
        boolean $i$f$map = false;
        Collection destination$iv$iv = (Collection) (new ArrayList());
        boolean $i$f$mapTo = false;
        Iterator var7 = $this$map$iv.iterator();

        while (var7.hasNext()) {
            Object item$iv$iv = var7.next();
            Person it = (Person) item$iv$iv;
            boolean var10 = false;
            PersonDTO var12 = it.toPersonDTO();
            destination$iv$iv.add(var12);
        }

        return (List) destination$iv$iv;
    }

    @Nullable
    public PersonDTO byUuid(@NotNull String uuid) {
        Person var10000 = this.getPersonRepository().findByUuid(uuid);
        return var10000 != null ? var10000.toPersonDTO() : null;
    }

    @NotNull
    public List byFirstname(@NotNull String firstname) {
        Iterable $this$map$iv = (Iterable) this.getPersonRepository().findByFirstname(firstname);
        boolean $i$f$map = false;
        Collection destination$iv$iv = (Collection) (new ArrayList());
        boolean $i$f$mapTo = false;
        Iterator var7 = $this$map$iv.iterator();

        while (var7.hasNext()) {
            Object item$iv$iv = var7.next();
            Person it = (Person) item$iv$iv;
            boolean var10 = false;
            PersonDTO var12 = it.toPersonDTO();
            destination$iv$iv.add(var12);
        }

        return (List) destination$iv$iv;
    }

    @NotNull
    public List byLastname(@NotNull String lastname) {
        Iterable $this$map$iv = (Iterable) this.getPersonRepository().findByLastname(lastname);
        boolean $i$f$map = false;
        Collection destination$iv$iv = (Collection) (new ArrayList());
        boolean $i$f$mapTo = false;
        Iterator var7 = $this$map$iv.iterator();

        while (var7.hasNext()) {
            Object item$iv$iv = var7.next();
            Person it = (Person) item$iv$iv;
            boolean var10 = false;
            PersonDTO var12 = it.toPersonDTO();
            destination$iv$iv.add(var12);
        }

        return (List) destination$iv$iv;
    }

    @NotNull
    public List<Person> all(@Nullable Integer size) {
        Iterable<Person> persons = this.getPersonRepository().findAll();
        List<Person> list = new ArrayList<>();
        persons.forEach(person -> list.add(person));
        return list;
     *//*   Iterable $this$map$iv = var10000;
        boolean $i$f$map = false;
        Collection destination$iv$iv = (Collection) (new ArrayList());
        boolean $i$f$mapTo = false;
        Iterator var7 = $this$map$iv.iterator();

        while (var7.hasNext()) {
            Object item$iv$iv = var7.next();
            Person it = (Person) item$iv$iv;
            boolean var10 = false;
            PersonDTO var12 = it.toPersonDTO();
            destination$iv$iv.add(var12);
        }

        return (List) destination$iv$iv;
        *//*

    }


    @NotNull
    public PersonRepository getPersonRepository() {
        return this.personRepository;
    }

    public GetPersonImpl(@NotNull PersonRepository personRepository) {

        this.personRepository = personRepository;
    }*/
}

