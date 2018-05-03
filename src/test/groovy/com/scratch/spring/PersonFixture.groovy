package com.scratch.spring

import com.scratch.spring.dao.PersonDao
import com.scratch.spring.model.Person
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PersonFixture {
  def log = LoggerFactory.getLogger(PersonFixture)

  @Autowired
  PersonDao dao

  void setup(int n = 5) {
    1.upto(n) {
      def person = new Person(firstName: "first-${it}", lastName: "last-${it}")
      person = dao.save(person)
      log.debug('created person={}', person)
    }
  }

  void teardown() {
    dao.deleteAll()
  }
}
