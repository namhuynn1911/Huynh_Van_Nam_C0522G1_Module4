package com.example_blog.dto;

import com.example_blog.model.Blogs;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Set;

public class CategoryDto {

    private int id;
    private String nameCategory;
    private Set<Blogs> blogs;

    public CategoryDto() {
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

    public Set<Blogs> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blogs> blogs) {
        this.blogs = blogs;
    }
}
