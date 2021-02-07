package com.test.project;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "clubs")
class Club {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToMany
  @JoinTable(
  name = "club_members", 
  joinColumns = @JoinColumn(name = "personId"), 
  inverseJoinColumns = @JoinColumn(name = "clubId"))
  private Set<Person> members = new HashSet<>();
  private String name;

  Club() {}

  Club(String name) {

    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public Set<Person> getMembers(){
    return this.members;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Club))
      return false;
      Club club = (Club) o;
    return Objects.equals(this.id, club.id) && Objects.equals(this.name, club.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "Address{" + "id=" + this.id + ", name='" + this.name +'\'' + '}';
  }
}