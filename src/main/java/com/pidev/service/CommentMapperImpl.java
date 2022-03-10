package com.pidev.service;



import com.pidev.dto.CommentsDto;
import com.pidev.mapper.CommentMapper;
import com.pidev.models.Comment;
import com.pidev.models.Comment.CommentBuilder;
import com.pidev.models.Post;

import com.pidev.models.User;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;


@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    date = "2020-07-22T15:53:55+0530",
	    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
	)
@Service
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment map(CommentsDto commentsDto, Post post, User user) {
        if ( commentsDto == null && post == null && user == null ) {
            return null;
        }

        Comment comment = new Comment();

        if ( commentsDto != null ) {
            comment.setText( commentsDto.getText() );
        }
        if ( post != null ) {
            comment.setPost( post );
        }
        if ( user != null ) {
            comment.setUser( user );
        }
        comment.setCreatedDate( java.time.Instant.now() );

        return comment;
    }

    @Override
    public CommentsDto mapToDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentsDto commentsDto = new CommentsDto();

        commentsDto.setId( comment.getId() );
        commentsDto.setCreatedDate( comment.getCreatedDate() );
        commentsDto.setText( comment.getText() );

        commentsDto.setUserName( comment.getUser().getUsername() );
        commentsDto.setPostId( comment.getPost().getPostId() );

        return commentsDto;
    }
}