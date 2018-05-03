package com.scratch.spring.dao

import com.scratch.spring.model.Person
import org.springframework.data.repository.CrudRepository

interface PersonDao extends CrudRepository<Person, Long> {
  // List<Person> findByLastName(String lastName)
}