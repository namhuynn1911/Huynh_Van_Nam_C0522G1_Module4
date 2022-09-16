package com.example_blog.service;



import com.example_blog.model.Blogs;

import java.util.List;

public interface IBlogsService {

    List<Blogs> findAll();

    void save(Blogs blogs);

    Blogs findById(int id);


    void update(Blogs blogs);

    void remove(int id);

}
