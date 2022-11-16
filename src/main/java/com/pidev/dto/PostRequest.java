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
public class PostRequest {
	public Long postId;
	public String subredditName;
	public String postName;
	public String url;
	public String description;
//	public Integer clickrate;
	public Integer keywords_number;

}