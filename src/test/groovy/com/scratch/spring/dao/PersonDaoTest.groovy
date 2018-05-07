package com.scratch.spring.dao

import com.scratch.spring.PersonFixture
import com.scratch.spring.model.Person
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest
class PersonDaoTest {
  def log = LoggerFactory.getLogger(PersonDaoTest)

  @Autowired
  PersonDao dao

  @Autowired
  PersonFixture fix

  @Before
  void before() {
    fix.teardown()
  }

  @Test
  void contextLoads() {
  }

  @Test
  void getAll() {
    def person = new Person(firstName: 'fred', lastName: 'jones')
    log.debug('pre-save: person={}', person)
    assert (dao)
    person = dao.save(person)
    log.debug('post-save: person={}', person)
    assert (person.id)
    def people = dao.findAll()
    assert (people.size() == 1)
    people.each { log.debug('it={}', it) }
  }

}
