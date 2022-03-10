package com.pidev.models;


import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.Instant;

@Entity
@Table
public class Ask {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String question;
    
    @Column
    private Instant time;
    

    @ManyToOne
    private User user;
       
    

//    @Column
//    @Nullable


    



    public Long getId() {
        return id;
    }


//    public String getSender() {
//        return forUser;
//    }
//
//    public void setForUser(String WhichPostedTheQuestion) {
//        this.forUser = WhichPostedTheQuestion;
//    }
//    
    
    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }
    
    
    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
