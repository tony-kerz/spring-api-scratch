package com.scratch.spring.dao

import com.scratch.spring.model.Person
import org.springframework.data.repository.PagingAndSortingRepository

interface PersonDao extends PagingAndSortingRepository<Person, Long> {
  // List<Person> findByLastName(String lastName)
}