package com.bs.myneighbourhood.core.domain.entities;


import com.bs.myneighbourhood.api.dto.Gender;
import com.bs.myneighbourhood.api.dto.PersonDTO;
import com.bs.myneighbourhood.data.neo4j.config.DateConverter;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import java.time.LocalDate;
import java.util.*;

@NodeEntity("Person")
public final class Person {
    @Index(
            unique = true,
            primary = true
    )
    @Property(
            name = "uuid"
    )
    @Id @GeneratedValue
    private Long uuid;
    
    private final String firstname;

    private final String lastname;

    private final String birthName;
    @Convert(DateConverter.class)
    private final LocalDate birthdate;
    
    private final Gender gender;
    @Relationship("SPOUSE_OF")
    private Person spouse;
    @Relationship("HAS_MOTHER")
    private Person mother;
    @Relationship("HAS_FATHER")
    private Person father;
    @Relationship("SIBLING_OF")
    private Set<Person> siblings;
    @Relationship("FRIEND_OF")
    private Set<Person> friends;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return uuid.equals(person.uuid) &&
                firstname.equals(person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(birthName, person.birthName) &&
                Objects.equals(birthdate, person.birthdate) &&
                gender == person.gender;
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }

    
    public final Long getUuid() {
        return this.uuid;
    }

    public final void setUuid( Long var1) {
        this.uuid = var1;
    }

    
    public final String getFirstname() {
        return this.firstname;
    }

    
    public final String getLastname() {
        return this.lastname;
    }

    
    public final String getBirthName() {
        return this.birthName;
    }

    
    public final LocalDate getBirthdate() {
        return this.birthdate;
    }

    
    public final Gender getGender() {
        return this.gender;
    }

    
    public final Person getSpouse() {
        return this.spouse;
    }

    public final void setSpouse( Person var1) {
        this.spouse = var1;
    }

    
    public final Person getMother() {
        return this.mother;
    }

    public final void setMother( Person var1) {
        this.mother = var1;
    }

    
    public final Person getFather() {
        return this.father;
    }

    public final void setFather( Person var1) {
        this.father = var1;
    }

    
    public final Set getSiblings() {
        return this.siblings;
    }

    public final void setSiblings( Set var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.siblings = var1;
    }

    
    public final Set getFriends() {
        return this.friends;
    }

    public final void setFriends( Set var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.friends = var1;
    }

    public Person( Long uuid,  String firstname,  String lastname,  String birthName,  LocalDate birthdate,  Gender gender,  Person spouse,  Person mother,  Person father,  Set siblings,  Set friends) {
        this.uuid = uuid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthName = birthName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.spouse = spouse;
        this.mother = mother;
        this.father = father;
        this.siblings = siblings;
        this.friends = friends;
    }

  /*  public final PersonDTO toPersonDTO() {
        String var10000 = this.uuid;
        String var10001 = this.firstname;
        String var10002 = this.lastname;
        String var10003 = this.birthName;
        LocalDate var10004 = this.birthdate;
        Gender var10005 = this.gender;
        Person var10006 = this.spouse;
        Person var1;
        boolean $i$f$map;
        boolean var3;
        boolean $i$f$mapTo;
        String var12;
        String var13;
        String var14;
        String var15;
        LocalDate var16;
        Gender var17;
        PersonDTO var18;
        PersonDTO var38;
        if (var10006 != null) {
            var1 = var10006;
            var17 = var10005;
            var16 = var10004;
            var15 = var10003;
            var14 = var10002;
            var13 = var10001;
            var12 = var10000;
            $i$f$map = false;
            var3 = false;
            $i$f$mapTo = false;
            var18 = new PersonDTO(var1.uuid, var1.firstname, var1.lastname, var1.birthName, var1.birthdate, var1.gender, (PersonDTO) null, (PersonDTO) null, (PersonDTO) null, (Set) null, (Set) null);
            var10000 = var12;
            var10001 = var13;
            var10002 = var14;
            var10003 = var15;
            var10004 = var16;
            var10005 = var17;
            var38 = var18;
        } else {
            var38 = null;
        }

        Person var10007 = this.mother;
        PersonDTO var19;
        PersonDTO var40;
        if (var10007 != null) {
            var1 = var10007;
            var18 = var38;
            var17 = var10005;
            var16 = var10004;
            var15 = var10003;
            var14 = var10002;
            var13 = var10001;
            var12 = var10000;
            $i$f$map = false;
            var3 = false;
            $i$f$mapTo = false;
            var19 = new PersonDTO(var1.uuid, var1.firstname, var1.lastname, var1.birthName, var1.birthdate, var1.gender, (PersonDTO) null, (PersonDTO) null, (PersonDTO) null, (Set) null, (Set) null);
            var10000 = var12;
            var10001 = var13;
            var10002 = var14;
            var10003 = var15;
            var10004 = var16;
            var10005 = var17;
            var38 = var18;
            var40 = var19;
        } else {
            var40 = null;
        }

        Person var10008 = this.father;
        PersonDTO var20;
        PersonDTO var41;
        if (var10008 != null) {
            var1 = var10008;
            var19 = var40;
            var18 = var38;
            var17 = var10005;
            var16 = var10004;
            var15 = var10003;
            var14 = var10002;
            var13 = var10001;
            var12 = var10000;
            $i$f$map = false;
            var3 = false;
            $i$f$mapTo = false;
            var20 = new PersonDTO(var1.uuid, var1.firstname, var1.lastname, var1.birthName, var1.birthdate, var1.gender, (PersonDTO) null, (PersonDTO) null, (PersonDTO) null, (Set) null, (Set) null);
            var10000 = var12;
            var10001 = var13;
            var10002 = var14;
            var10003 = var15;
            var10004 = var16;
            var10005 = var17;
            var38 = var18;
            var40 = var19;
            var41 = var20;
        } else {
            var41 = null;
        }

        Iterable $this$map$iv = (Iterable) this.siblings;
        var20 = var41;
        var19 = var40;
        var18 = var38;
        var17 = var10005;
        var16 = var10004;
        var15 = var10003;
        var14 = var10002;
        var13 = var10001;
        var12 = var10000;
        $i$f$map = false;
        Collection destination$iv$iv = (Collection) (new ArrayList());
        $i$f$mapTo = false;
        Iterator var6 = $this$map$iv.iterator();

        Object item$iv$iv;
        Person it;
        boolean var9;
        while (var6.hasNext()) {
            item$iv$iv = var6.next();
            it = (Person) item$iv$iv;
            var9 = false;
            PersonDTO var22 = new PersonDTO(it.uuid, it.firstname, it.lastname, it.birthName, it.birthdate, it.gender, (PersonDTO) null, (PersonDTO) null, (PersonDTO) null, (Set) null, (Set) null);
            destination$iv$iv.add(var22);
        }

        List var21 = (List) destination$iv$iv;
        Set var10009 = CollectionsKt.toMutableSet((Iterable) var21);
        $this$map$iv = (Iterable) this.friends;
        Set var37 = var10009;
        $i$f$map = false;
        destination$iv$iv = (Collection) (new ArrayList());
        $i$f$mapTo = false;
        var6 = $this$map$iv.iterator();

        while (var6.hasNext()) {
            item$iv$iv = var6.next();
            it = (Person) item$iv$iv;
            var9 = false;
            PersonDTO var23 = new PersonDTO(it.uuid, it.firstname, it.lastname, it.birthName, it.birthdate, it.gender, (PersonDTO) null, (PersonDTO) null, (PersonDTO) null, (Set) null, (Set) null);
            destination$iv$iv.add(var23);
        }

        List var39 = (List) destination$iv$iv;
        Set var36 = CollectionsKt.toMutableSet((Iterable) var39);
        return new PersonDTO(var12, var13, var14, var15, var16, var17, var19, var20, var18, var37, var36);
    }
*/

}