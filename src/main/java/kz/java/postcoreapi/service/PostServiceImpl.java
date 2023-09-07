package kz.java.postcoreapi.service;

import kz.java.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl  implements PostService{

    private static final HashMap<String, PostModel> postMap = new HashMap<>();

    static {

        PostModel postModel1 = new PostModel(UUID.randomUUID().toString(),
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Car", "done!");

        PostModel postModel2 = new PostModel(UUID.randomUUID().toString(),
                UUID.randomUUID().toString(), UUID.randomUUID().toString(), "clothes", "in release");

        postMap.put(postModel1.getPostId(), postModel1);
        postMap.put(postModel2.getPostId(), postModel2);
    }

    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        postMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public void deletePostById(String postId) {
        postMap.remove(postId);
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        postModel.setPostId(postId);
        postMap.put(postId, postModel);
    }

    @Override
    public List<PostModel> getAllPost() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postMap.get(postId);
    }
}
