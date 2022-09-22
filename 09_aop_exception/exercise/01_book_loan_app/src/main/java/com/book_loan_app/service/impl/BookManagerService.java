package com.book_loan_app.service.impl;

import com.book_loan_app.model.BookManager;
import com.book_loan_app.repository.IBookManagerRepository;
import com.book_loan_app.service.IBookManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookManagerService implements IBookManagerService {

    @Autowired
    private IBookManagerRepository iBookManagerRepository;

    @Override
    public BookManager findById(int id) {
        return iBookManagerRepository.findById(id);
    }

    @Override
    public Page<BookManager> findIdAndShowBook(String name, Pageable pageable) {
        return iBookManagerRepository.findByName(name,pageable);
    }

    @Override
    public BookManager bookBorrow(BookManager bookManager) throws Exception {
        bookManager.setAmount(bookManager.getAmount()-1);
        return iBookManagerRepository.save(bookManager);
    }

    @Override
    public BookManager bookPay(BookManager bookManager) {
        bookManager.setAmount(bookManager.getAmount()+1);
        return iBookManagerRepository.save(bookManager);
    }
}
