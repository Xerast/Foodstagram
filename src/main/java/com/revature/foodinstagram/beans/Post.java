package com.revature.foodinstagram.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts", schema = "Project2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postid")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "posterid")
    private User user;
    @Transient
    private List<Comment> comment = new ArrayList<>();

    private String title;
    private String body;
    private String image_url;
    private Boolean recommend_rest;
    private Integer rating;


}