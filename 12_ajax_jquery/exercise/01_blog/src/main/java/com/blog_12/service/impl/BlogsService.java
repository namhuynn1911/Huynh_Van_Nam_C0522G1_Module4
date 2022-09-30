package com.blog_12.service.impl;


import com.blog_12.model.Blogs;
import com.blog_12.repository.IBlogsRepository;
import com.blog_12.service.IBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogsService implements IBlogsService {

    @Autowired
    private IBlogsRepository iBlogsRepository;



    @Override
    public List<Blogs> findAll() {
        return iBlogsRepository.findAll();
    }

    @Override
    public void save(Blogs blogs) {
        iBlogsRepository.save(blogs);
    }

    @Override
    public Blogs findById(int id) {
        return iBlogsRepository.findById(id);
    }

    @Override
    public void update(Blogs blogs) {
        iBlogsRepository.save(blogs);
    }

    @Override
    public void remove(int id) {
        iBlogsRepository.delete(findById(id));
    }



    @Override
    public Page<Blogs> findAll(Pageable pageable) {
        return iBlogsRepository.findAll(pageable);
    }

    @Override
    public Page<Blogs> findByName(String name,Pageable pageable) {
        return iBlogsRepository.searchByName(name,pageable);
    }

//    @Override
//    public List<IBlogDto> showTitle() {
//        return iBlogsRepository.showTitle();
//    }
}