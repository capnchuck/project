package com.test.project.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "personalInfo")
public class PersonalInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;
  private String firstName;
  private String lastName;
  private String phoneNumber;

  @OneToOne(mappedBy = "personalInfo")
  private Person person;

  public PersonalInfo() {}

  public PersonalInfo(String firstName, String lastName, String phoneNumber) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  public Long getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof PersonalInfo))
      return false;
      PersonalInfo personalInfo = (PersonalInfo) o;
    return Objects.equals(this.id, personalInfo.id) && Objects.equals(this.firstName, personalInfo.firstName)
        && Objects.equals(this.lastName, personalInfo.lastName) && Objects.equals(this.phoneNumber, personalInfo.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.firstName, this.lastName, this.phoneNumber);
  }

  @Override
  public String toString() {
    return "PersonalInfo{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", phoneNumber='" + this.phoneNumber + '\'' + '}';
  }
}