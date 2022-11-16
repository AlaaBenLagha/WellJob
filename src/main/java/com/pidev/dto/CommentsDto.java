package com.pidev.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;





@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
	private Long id;
    private Long postId;
    private String createdDate;
    private String text;
    private String userName;
}

