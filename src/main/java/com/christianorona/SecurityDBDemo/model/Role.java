package com.christianorona.SecurityDBDemo.model;

import javax.persistence.*;

@Entity
@Table(name="Role")
public class Role {

    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="role_id")
        private int id;
        @Column(name="role")
        private String role;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
