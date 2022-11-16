package com.pidev.controllers;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;

import com.pidev.controllers.QuizController.SortingMethod;
import com.pidev.dto.PostRequest;
import com.pidev.dto.PostResponse;
import com.pidev.models.Post;
import com.pidev.service.PostService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pidev.models.Category;
import com.pidev.models.Quiz;
import com.pidev.serviceInterface.QuizService;
import lombok.AllArgsConstructor;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/posts/")
@AllArgsConstructor
public class PostController {

	private final PostService postService;

	@PostMapping
	public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
		postService.save(postRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<PostResponse>> getAllPosts() {
		return status(HttpStatus.OK).body(postService.getAllPosts());
	}


	
	
	@GetMapping("/by-id/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable("id") Long id) {
        return status(HttpStatus.OK).body(postService.getPost(id));
    }

	@GetMapping("/by-subreddit/{id}")
	public ResponseEntity<List<PostResponse>> getPostsBySubreddit(@PathVariable Long id) {
		
		return status(HttpStatus.OK).body(postService.getPostsBySubreddit(id));
	}

	@GetMapping("/by-user/{username}")
	public ResponseEntity<List<PostResponse>> getPostsByUsername(@PathVariable String username) {
		return status(HttpStatus.OK).body(postService.getPostsByUsername(username));
	}

	@Autowired
	private QueryParser translater;

	
	@Async
	@PostMapping("/search/{content}")
	public ResponseEntity<ArrayList<PostResponse>> searchlist(@PathVariable("content") String content) {
		ArrayList<String> word_list = (ArrayList<String>) translater.parseQuery(content);
		HashSet<String> keywords_set = new HashSet<String>();
		for (int i = 0; i < word_list.size(); i++) {
			keywords_set.add(word_list.get(i));
		}

		ArrayList<PostResponse> posts_list = (ArrayList<PostResponse>) postService.getAllPosts();
		ArrayList<PostResponse> candidates = new ArrayList<PostResponse>();

		for (int i = 0; i < posts_list.size(); i++) {
			if (keywords_set.contains(posts_list.get(i).getId())) {
				candidates.add(posts_list.get(i));
				int index;

			}
		}

		for (int i = 0; i < posts_list.size(); i++) {
			String temp[] = posts_list.get(i).getPostName().split("[^a-zA-Z0-9']+");
			int count = 0;
			for (String str : temp) {
				if (keywords_set.contains(str)) {
					count++;	
				}
			}
			if (count > 0) {
				posts_list.get(i).setKeywords_number(count);
				candidates.add(posts_list.get(i));
			}
		}
		
		Collections.sort(candidates, new SortingMethod());
		return ResponseEntity.ok(candidates);
		
	}
	
	



	class SortingMethod implements Comparator<PostResponse> {



			@Override
			public int compare(PostResponse q1, PostResponse q2) {
		
				double score1 = q1.getVoteCount()*0.5 + q1.getKeywords_number()*10;
				double score2 = q2.getVoteCount()*0.5 + q2.getKeywords_number()*10;
					if (score1 > score2) {
						return -1;
							}else {
								return 1;
							}
			}
	}

	
	
	
}

