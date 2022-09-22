package com.book_loan_app.repository;

import com.book_loan_app.model.BookManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookManagerRepository extends JpaRepository<BookManager,Integer> {

  BookManager findById(int id);

    @Query(value = "select  * from book_manager where name like %:keyword%",nativeQuery = true)
    Page<BookManager> findByName(@Param("keyword") String name, Pageable pageable);
}
