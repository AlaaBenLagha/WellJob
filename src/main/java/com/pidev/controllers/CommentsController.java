package com.pidev.controllers;

import com.pidev.dto.CommentsDto;

import com.pidev.service.BadWordFilter;
import com.pidev.service.CommentService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/api/comments/")
@AllArgsConstructor
public class CommentsController {
    private final CommentService commentService;
    
    private final BadWordFilter BadWordFilter;

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody CommentsDto commentsDto) {
    	commentsDto.setText(BadWordFilter.getCensoredText(commentsDto.getText()));
    	
        commentService.save(commentsDto);
        return new ResponseEntity<String>(commentsDto.getText(),HttpStatus.ACCEPTED);
    }
    
    
    

    @GetMapping("/by-post/{postId}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForPost(@PathVariable Long postId) {
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForPost(postId));
    }

    
    
    
    
    @GetMapping("/by-user/{userName}")
    public ResponseEntity<List<CommentsDto>> getAllCommentsForUser(@PathVariable String userName){
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForUser(userName));
    }

}
