package com.pidev.mapper;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.pidev.dto.CommentsDto;
import com.pidev.models.Comment;
import com.pidev.models.Post;
import com.pidev.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "commentMapper")
public abstract class CommentMapper {

		@Mapping(target = "id", ignore = true)
	    @Mapping(target = "text", source = "commentsDto.text")
		@Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
	    @Mapping(target = "post", source = "post")
	    @Mapping(target = "user", source = "user")
	  public abstract Comment map(CommentsDto commentsDto, Post post, User user);
	    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
	    @Mapping(target = "userName", expression = "java(comment.getUser().getUsername())")

	    public abstract CommentsDto mapToDto(Comment comment);
	   
	    
	    public static String getCreationDate(Comment comment) {
	        return TimeAgo.using(comment.getCreatedDate().toEpochMilli());
	    }

	   
}
