package com.test.project.model;

import javax.persistence.*;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "persons")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  private String username;
  private String password;
  private String role;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "personalInfo_id", referencedColumnName = "id")
  private PersonalInfo personalInfo;

  @ManyToMany
  private Set<Club> clubs = new HashSet<>();

  public Person() 
  {
  }

  public Person(String firstName, String lastName, String phoneNumber, String username, String password, String role) {

    this.username = username;
    this.password = password;
    this.role = role;
    this.personalInfo = new PersonalInfo(firstName, lastName, phoneNumber);
  }

  public Long getId() {
    return this.id;
  }

  public String getRole() {
    return this.role;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername(){
    return this.username;
  }

  public String getPassword(){
    return this.password;
  }

  public PersonalInfo getPersonalInfo(){
    return this.personalInfo;
  }

  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

    list.add(new SimpleGrantedAuthority("ROLE_" + this.role));

    return list;
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
}