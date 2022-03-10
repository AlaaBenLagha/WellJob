package com.pidev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

import com.pidev.models.Post;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
	private Long id;
    private Long postId;
    private Instant createdDate;
    private String text;
    private String userName;
}

