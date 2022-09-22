package com.book_loan_app.service;

import com.book_loan_app.model.BookManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookManagerService {

    BookManager findById(int id);

    Page<BookManager> findIdAndShowBook(String name, Pageable pageable);

    BookManager bookBorrow(BookManager bookManager) throws Exception;

    BookManager bookPay(BookManager bookManager);
}
