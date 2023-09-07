package kz.java.postcoreapi.controller;

import jakarta.validation.Valid;
import kz.java.postcoreapi.model.PostModel;
import kz.java.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController{
    @Autowired
    private PostService postService;
    @GetMapping("/check")
    public String checkPost(){
        return "post-core-api is working";
    }

    @GetMapping("/all")
    public List<PostModel> getAllPost(){
        return postService.getAllPost();
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId){
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable String postId, @Valid @PathVariable PostModel postModel){
        postService.updatePostById(postId, postModel);
        return new ResponseEntity<String>("Successfully Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId){
        postService.deletePostById(postId);
        return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
    }
}
