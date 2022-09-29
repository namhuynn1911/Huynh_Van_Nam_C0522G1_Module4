package com.blog_12.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    @JsonIgnore
    @JsonManagedReference
//    @JsonBackReference
    private Set<com.blog_12.model.Blogs> blogs;

    public Set<com.blog_12.model.Blogs> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<com.blog_12.model.Blogs> blogs) {
        this.blogs = blogs;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
