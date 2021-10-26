package com.revature.foodinstagram.controllers;

import com.revature.foodinstagram.beans.Comment;
import com.revature.foodinstagram.beans.Post;
import com.revature.foodinstagram.beans.User;
import com.revature.foodinstagram.repositories.CommentRepo;
import com.revature.foodinstagram.repositories.PostRepo;
import com.revature.foodinstagram.services.PostServices;
import com.revature.foodinstagram.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private final PostServices postServices;
    private final UserServices userServices;

    @Autowired
    public PostController(PostServices postServices, UserServices userServices) {
        this.postServices = postServices;
        this.userServices = userServices;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postServices.getAllPosts();
    }

    @GetMapping(path = "/{id}")
    public Post getById(@PathVariable("id") int id) {
        return postServices.getPostById(id);
    }


    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addPost(@CookieValue(value = "id", defaultValue = "1")String id, @RequestBody Post post) {
        int userId = Integer.parseInt(id);
        User user = userServices.getUserById(userId);
        post.setUser(user);
        postServices.addPost(post);

    }

    @PutMapping(path="/{id}")
    public void updatePost(@PathVariable("id") int id, @RequestBody Post post) {
        if (id == post.getId()) {
            postServices.updatePost(post);// this save method is coming from the JpaRepository -> it is like Hibernate's saveOrUpdate();
        }
    }

    @DeleteMapping(path="/{id}")
    public void deletePost(@PathVariable("id") int id) {
        postServices.deletePost(id);
    }
}