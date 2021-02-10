package com.test.project.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private long id;
    @Column(name = "ROLE")
    private String role;

    public String getRole(){
        return this.role;
    }

    public long getId(){
        return this.id;
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
