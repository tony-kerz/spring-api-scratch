package com.scratch.spring.control

import com.scratch.spring.dao.PersonDao
import com.scratch.spring.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

  @Autowired
  PersonDao dao

  @RequestMapping('/people')
  Iterable<Person> index() {
    return dao.findAll()
  }
}
