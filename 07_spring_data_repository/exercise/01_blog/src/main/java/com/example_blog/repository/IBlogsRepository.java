package com.example_blog.repository;


import com.example_blog.model.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface IBlogsRepository extends JpaRepository<Blogs,Integer> {

    Blogs findById(int id);

    @Query(value = "select * from blogs where name_blog like %:keyword% ",nativeQuery = true)
    Page<Blogs> searchByName(@Param("keyword") String name, Pageable pageable);

    @Query(value = "select  * from blogs order by date_created DESC ",nativeQuery = true)
    Page<Blogs> findAll(Pageable pageable);
}
