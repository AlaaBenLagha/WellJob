package com.pidev.service;

import com.pidev.dto.CommentsDto;
import com.pidev.exception.PostNotFoundException;
import com.pidev.exception.SpringRedditException;
import com.pidev.mapper.CommentMapper;
import com.pidev.models.Comment;
import com.pidev.models.NotificationEmail;
import com.pidev.models.Post;
import com.pidev.models.User;
import com.pidev.repository.CommentRepository;
import com.pidev.repository.PostRepository;
import com.pidev.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CommentService {
    private static final String POST_URL = "";
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;

    public void save(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));
        Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
        commentRepository.save(comment);

        String message = mailContentBuilder.build( "                                                                                                                                                        |||   The User : "+ comment.getUser().getUsername() + " Posted a comment on your post.  " + "                                                                                                                                                        |||   He Said :  " + comment.getText()+"                                                                                                                                                             " );
        sendCommentNotification(message, comment.getUser());
    }

    private void sendCommentNotification(String message, User user ) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + " Commented on your post", user.getEmail(), message));
    }

    
    @Transactional(readOnly = true)
    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentRepository.findByPost(post)
                .stream()
                .map(commentMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return commentRepository.findAllByUser(user)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(toList());
    }

    

    public boolean containsSwearWords(String comment) {
        if (comment.contains("Shit")
        	||comment.contains("Fuck")
        	||comment.contains("Piss off")
        	||comment.contains("Asshole")
        	||comment.contains("Bastard")
        	||comment.contains("Dick head")
        	||comment.contains("Bitch")
        	||comment.contains("Damn")
        	
        	||comment.contains("fuck")
        	||comment.contains("shit")
        	||comment.contains("piss off")
        	||comment.contains("asshole")
        	||comment.contains("bastard")
        	||comment.contains("dick head")
        	||comment.contains("bitch")
        	||comment.contains("damn")
        	
        	||comment.contains("FUCK")
        	||comment.contains("SHIT")
        	||comment.contains("PISS OFF")
        	||comment.contains("ASSHOLE")
        	||comment.contains("BASTARD")
        	||comment.contains("DICK HEAD")
        	||comment.contains("BITCH")
        	||comment.contains("DAMN")               ){
        	
        		throw new SpringRedditException("Comments contains unacceptable language");
        	
        }
        return false;
    }
}
