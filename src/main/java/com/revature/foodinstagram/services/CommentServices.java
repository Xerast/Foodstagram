package com.revature.foodinstagram.services;

import com.revature.foodinstagram.beans.Comment;
import com.revature.foodinstagram.beans.Post;
import com.revature.foodinstagram.repositories.CommentRepo;
import com.revature.foodinstagram.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServices {

    private final CommentRepo commentRepo;

    @Autowired
    public CommentServices(CommentRepo commentRepo){
        this.commentRepo = commentRepo;
    }

    public Comment addComment(Comment comment) {
        if(comment != null){
            Comment c  = commentRepo.save(comment);
            return c;
        }
        return null;
    }

    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    public Comment getCommentById(Integer id){
        Optional<Comment> c = commentRepo.findById(id);
        return c.orElse(null);
    }

    public void updateComment(Comment comment){
        if(comment != null){
            commentRepo.save(comment);
        }
    }

    public void deleteComment(Integer id){
        commentRepo.delete(commentRepo.getById(id));
    }




}