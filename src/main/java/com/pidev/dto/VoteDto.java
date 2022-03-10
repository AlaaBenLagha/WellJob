package com.pidev.dto;

import com.pidev.models.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto {
	private Long postId;
    private VoteType voteType;
   
}
