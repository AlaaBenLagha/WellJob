package com.pidev.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pidev.models.Collaboration;
import com.pidev.models.PostNewsFeed;
import com.pidev.serviceInterface.IPostNewsFeedService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/post")
public class PostNewsFeedRestController {
	
	@Autowired
	IPostNewsFeedService postService;
	
			//http://localhost:8082/SpringMVC/post/addpost
			@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/addpost")
			@ResponseBody	
			public PostNewsFeed addPost(@RequestPart(value = "post") PostNewsFeed post,
					@RequestPart(value = "image") MultipartFile multipartFile) throws IOException {
//				 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//				 post.setPhotos(fileName);
//				 PostNewsFeed savedPost = postService.addPost(post);
//				 String uploadDir ="/post-photos/" + savedPost.getIdPost();
//				 Path uploadPath =Paths.get(uploadDir);
//				 if(!Files.exists(uploadPath)){
//					 Files.createDirectories(uploadPath);
//				 }
//				 try (InputStream inputStream = multipartFile.getInputStream()){
//				 Path filePath = uploadPath.resolve(fileName);
//				 Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
//				 } catch (IOException e){
//					 throw new IOException("could not save"+ fileName);
//				 }
//				return postService.addPost(post);	
				String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				post.setPhotos(fileName);
		         
				PostNewsFeed savedPost = postService.addPost(post);
		 
		        String uploadDir = "user-photos/" + savedPost.getIdPost();
		 
		        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
				return savedPost;

			}
			
			//http://localhost:8082/SpringMVC/post/getpost/
			@GetMapping("/getpost/{id}")
			@ResponseBody
			public PostNewsFeed getPost(@PathVariable("id")  Long id) {
				return postService.getPost(id);

			}
			
			//http://localhost:8082/SpringMVC/post/getallposts
			@GetMapping("/getallposts")
			@ResponseBody
			public List<PostNewsFeed> getPosts() {
				return postService.getAllPosts();

			}
			
			//http://localhost:8082/SpringMVC/post/deletepost/
			@DeleteMapping("/deletepost/{id}")
			@ResponseBody
			public void deletePost(@PathVariable("id")  Long id) {
				postService.deletePost(id);

			}
			
			//http://localhost:8082/SpringMVC/post/updatepost/
			@PutMapping("/updatepost/{id}")
			@ResponseBody
			public PostNewsFeed updatePost(@RequestBody PostNewsFeed post, @PathVariable("id")  Long id) {
				return postService.updatePost(post, id);

			}
			
			//http://localhost:8082/SpringMVC/post/getbyuser/
			@GetMapping("/getbyuser/{id}")
			@ResponseBody
			public List<PostNewsFeed> getPostsByUser(@PathVariable("id")  Long idUser) {
				return postService.getPostsByUser(idUser);

			}
			
			//http://localhost:8082/SpringMVC/post/getpostbytitle/
			@GetMapping("/getpostbytitle/{titlePost}")
			@ResponseBody
			public List<PostNewsFeed> getPostByTitle(@PathVariable("titlePost") String TitlePost) {
				return postService.getPostByTitle(TitlePost);
				
			}
			
//			@PostMapping("/uploadimage")
//		    public void saveUser(PostNewsFeed post,
//		            @RequestParam("image") MultipartFile multipartFile) throws IOException {
//		         
//		        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		        post.setPhotos(fileName);
//		         
//		        PostNewsFeed savedPost = postService.addPost(post);
//		 
//		        String uploadDir = "user-photos/" + savedPost.getId();
//		 
//		        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//		         
//		      
//		    }

}
