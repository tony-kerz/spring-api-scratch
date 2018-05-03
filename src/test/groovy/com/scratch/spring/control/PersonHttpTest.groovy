package com.scratch.spring.control

import com.scratch.spring.PersonFixture
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PersonHttpTest {
  def log = LoggerFactory.getLogger(PersonHttpTest)

  @LocalServerPort
  def port

  @Autowired
  TestRestTemplate restTemplate

  @Autowired
  PersonFixture fix

  @Before
  void before() {
    fix.setup()
  }

  @After
  void after() {
    fix.teardown()
  }

  @Test
  void index() throws Exception {
    def res = this.restTemplate.getForObject("http://localhost:${port}/people", String.class)
    log.debug('response={}', res)
  }
}