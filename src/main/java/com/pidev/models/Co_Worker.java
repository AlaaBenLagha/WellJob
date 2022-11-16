package com.pidev.models;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table
public class Co_Worker {
    @Id
    @GeneratedValue
    private Long id;

    // the email of Co_Worker
    @Column
    @Email
    private String email ;

    @ManyToOne
    private User user;


    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
