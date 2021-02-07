package com.test.project;

import java.util.Objects;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "persons")
class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "personalInfo_id", referencedColumnName = "id")
  private PersonalInfo personalInfo;

  @ManyToMany
  private Set<Club> clubs = new HashSet<>();

  Person() {}

  Person(String firstName, String lastName, String phoneNumber) {

    this.personalInfo = new PersonalInfo(firstName, lastName, phoneNumber);
  }

  public Long getId() {
    return this.id;
  }

  // public Set<Address> getAddresses(){
  //   return this.addresses;
  // }

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