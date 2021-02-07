package com.test.project;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "persons")
class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "personalInfo_id", referencedColumnName = "id")
  private PersonalInfo personalInfo;

  Person() {}

  Person(String firstName, String lastName, String phoneNumber) {

    this.personalInfo = new PersonalInfo(firstName, lastName, phoneNumber);
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Person))
      return false;
      Person person = (Person) o;
    return Objects.equals(this.id, person.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override
  public String toString() {
    return "Person{" + "id=" + this.id + "," + personalInfo.toString() + '}';
  }
}