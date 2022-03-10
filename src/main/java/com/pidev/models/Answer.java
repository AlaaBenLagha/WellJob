package com.pidev.models;


import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table
// this is post and answer in profile
public class Answer {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    @Nullable
    private String email ; // the questioner
    @Column
    private String answer;
    @Column
    private Instant time;
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Ask ask;



    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    public Ask getAsk() {
        return ask;
    }

    public void setAsk( Ask ask) {
        this.ask = ask;
    }

//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Ask ask) {
//        this.question = ask;
//    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }
}
