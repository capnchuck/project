package com.test.project.model;

import java.util.Objects;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "persons")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "personalInfo_id", referencedColumnName = "id")
  private PersonalInfo personalInfo;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
  private Set<Role> roles;

  @ManyToMany
  private Set<Club> clubs = new HashSet<>();

  private String username;
  private String password;

  public Person() {}

  public Person(String firstName, String lastName, String phoneNumber, String username, String password) {

    this.username = username;
    this.password = password;
    this.personalInfo = new PersonalInfo(firstName, lastName, phoneNumber);
  }

  public Long getId() {
    return this.id;
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRoles(HashSet<Role> roles) {
    this.roles = roles;
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