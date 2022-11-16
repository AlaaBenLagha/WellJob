package com.pidev.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;  
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long postId;
    @NotBlank(message = "Post Name cannot be empty or Null")
    private String postName;
    @Nullable
    private String url;
    @Nullable
    private String description;
    private Integer voteCount;
    
    
//    @Nullable
//    @JsonIgnore
//    private int clickrate;
    
    
    @Nullable
    @JsonIgnore
    public int keywords_number;
    
    private Instant createdDate;
    
    
    
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Subreddit subreddit;
    
    
    
    
    public int getKeywords_number() {
		return keywords_number;
	}

	public void setKeywords_number(int keywords_number) {
		this.keywords_number = keywords_number;
	}
	
//	
//	 public int getClickrate() {
//			return clickrate;
//		}
//
//	public void setClickrate(int clickrate) {
//			this.clickrate = clickrate;
//	}
	
	
	
	
}
