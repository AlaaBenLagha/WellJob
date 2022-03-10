package com.pidev.models;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import com.pidev.models.*;
import com.sun.istack.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import static javax.persistence.GenerationType.SEQUENCE;



@Getter
@Setter
@Table(name ="user")
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
	private static final long serialVersionUID = 1L; 

@Id
@GeneratedValue(strategy = SEQUENCE)
private Long userId;
@NotBlank(message = "Username is required")
private String username;
@NotBlank(message = "Password is required")
private String password;
@Email
@NotEmpty(message = "Email is required")
private String email;
private Instant created;
private boolean enabled;	
private String firstname;
private double score;
private String lastname;

private String phonenumber;
private String profile;


//@Embedded
//@Nullable
//private Profil userProfile;



@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
private Set<Reservation> reservations;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
private Set<Collaboration> collaborations;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
private Set<Offre> offres;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
private Set<ReviewCompany> companyReviews;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
private Set<ConversationPart> conversationParts;
@JsonIgnore
@OneToOne
private Profil profil;
@JsonIgnore
@OneToOne
private MessageBox messageBox;
@JsonIgnore
@ManyToMany(cascade = CascadeType.ALL)
private Set<Event> events;
@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
private Set<Quiz> quizs;
@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")

private Set<UserRole> userRole=new HashSet<>();

@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
@JsonIgnore
private List<Co_Worker> co_Workers = new ArrayList<>();

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
@JsonIgnore
private List<Ask> asks = new ArrayList<>();

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
@JsonIgnore
private List<Answer> answers = new ArrayList<>();

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
@JsonIgnore
private List<BlockList> blockList  = new ArrayList<>();





public Set<UserRole> getUserRole() {
	return userRole;
}

public void setUserRole(Set<UserRole> userRole) {
	this.userRole = userRole;
}


public double getScore() {
	return score;
}

public void setScore(double score) {
	this.score = score;
}



public User(String username, String email, String password, String firstname, String lastname, String phonenumber,
		boolean enabled, String profile, Set<UserRole> userRole) {
	super();
	this.username = username;
	this.email = email;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
	this.phonenumber = phonenumber;
	this.enabled = enabled;
	this.profile = profile;
	this.userRole = userRole;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}


//
//@Override
//public boolean isAccountNonExpired() {
//	// TODO Auto-generated method stub
//	return true;
//}
//
//@Override
//public boolean isAccountNonLocked() {
//	// TODO Auto-generated method stub
//	return true;
//}
//
//@Override
//public boolean isCredentialsNonExpired() {
//	// TODO Auto-generated method stub
//	return true;
//}
//
//@Override
//public Collection<? extends GrantedAuthority> getAuthorities() {
//	// TODO Auto-generated method stub
//	return null;
//}


public List<Co_Worker> getCommunities() {
    return co_Workers;
}

public void setCommunities(List<Co_Worker> co_Workers) {
    this.co_Workers = co_Workers;
}


public List<Ask> getAsks() {
    return asks;
}

public void setAsks(List<Ask> asks) {
    this.asks = asks;
}

public List<Answer> getAnswers() {
    return answers;
}

public void setAnswers(List<Answer> answers) {
    this.answers = answers;
}
    
    public List<BlockList> getBlockList() {
        return blockList;
    }
    
    public void setBlockList(List<BlockList> blockList) {
        this.blockList = blockList;
    }


//    public Profil getUserProfile() {
//        return userProfile;
//    }
//
//    public void setUserProfile(Profil userProfile) {
//        this.userProfile = userProfile;
//    }

    
    
    
    
    

	
}
