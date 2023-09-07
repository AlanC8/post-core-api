package kz.java.postcoreapi.service;

import kz.java.postcoreapi.model.PostModel;

import java.util.List;

public interface PostService {
    void createPost(PostModel postModel);
    void deletePostById(String postId);
    void updatePostById(String postId, PostModel postModel);
    List<PostModel> getAllPost();
    PostModel getPostById(String postId);
}
