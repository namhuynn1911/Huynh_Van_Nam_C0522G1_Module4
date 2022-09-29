package com.blog_12.service;



import com.blog_12.model.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogsService {

    List<Blogs> findAll();

    void save(Blogs blogs);

    Blogs findById(int id);


    void update(Blogs blogs);

    void remove(int id);

    Page<Blogs> findAll(Pageable pageable);

    Page<Blogs> findByName(String name,Pageable pageable);

//    List<IBlogDto> showTitle();
}
