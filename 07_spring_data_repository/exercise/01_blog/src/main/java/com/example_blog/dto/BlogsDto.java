package com.example_blog.dto;

import com.example_blog.model.Category;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BlogsDto {

    private int id;
    private String creatorBlog;
    private String nameBlog;
    private String dateCreated;
    private String content;
    private String linkBlog;
    private Category category;

    public BlogsDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatorBlog() {
        return creatorBlog;
    }

    public void setCreatorBlog(String creatorBlog) {
        this.creatorBlog = creatorBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLinkBlog() {
        return linkBlog;
    }

    public void setLinkBlog(String linkBlog) {
        this.linkBlog = linkBlog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
