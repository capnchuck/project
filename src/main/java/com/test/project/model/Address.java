package com.test.project.model;

import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Addresses")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Person person;

  private String address;
  private String city;
  private String state;
  private String zipCode;

  public Address() {}

  public Address(String address, String city, String state, String zipcode) {

    this.address = address;
    this.city = city;
    this.state = state;
    this.zipCode = zipcode;
  }

  public Long getId() {
    return this.id;
  }

  public String getAddress() {
    return this.address;
  }

  public String getCity() {
    return this.city;
  }

  public String getState() {
    return this.state;
  }

  public String getZipCode() {
    return this.zipCode;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public void setPerson(Person person){
    this.person = person;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Address))
      return false;
      Address address = (Address) o;
    return Objects.equals(this.id, address.id) && Objects.equals(this.address, address.address) && Objects.equals(this.city, address.city)
    && Objects.equals(this.state, address.state) && Objects.equals(this.zipCode, address.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.address, this.city, this.state, this.zipCode);
  }

  @Override
  public String toString() {
    return "Address{" + "id=" + this.id + ", address='" + this.address + '\'' + ", city='" + this.city +  '\'' + ", state='" + this.state +'\'' + ", zipCode='" + this.zipCode + '\'' + '}';
  }
}