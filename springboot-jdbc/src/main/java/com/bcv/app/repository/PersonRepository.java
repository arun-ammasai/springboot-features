package com.bcv.app.repository;

import com.bcv.app.entity.Person;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository  extends CrudRepository<Person,Long> {

    List<Person> findByFirstName(String firstName);

    @Query("UPDATE person SET first_name = :name WHERE id = :id")
    boolean updateByFirstName(@Param("id") Long id, @Param("name") String name);

    @Query("delete from person where id= :id")
    void deletePerson(@Param("id") Long id);

}
