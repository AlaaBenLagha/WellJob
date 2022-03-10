package com.pidev.dto;





import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class PostResponse {
	public Long id;
	public String postName;
	public String url;
	public String description;
	public String userName;
	public String subredditName;
	public Integer voteCount;
	public Integer commentCount;
  //usin time ago library ( kotlin ) 
	public String duration;
	public Integer keywords_number;
//	public Integer clickrate;
	public boolean upVote;
	public boolean downVote;
 
    
}
