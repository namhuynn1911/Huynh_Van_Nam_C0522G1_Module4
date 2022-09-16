package com.example_blog.repository;


import com.example_blog.model.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogsRepository extends JpaRepository<Blogs,Integer> {

    Blogs findById(int id);
}
