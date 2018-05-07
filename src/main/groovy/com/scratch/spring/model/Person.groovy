package com.scratch.spring.model

import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@ToString(includeNames = true)
@Entity
class Person {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  Long id

  String lastName
  String firstName
}
