package com.example.case_study.service;

import com.example.case_study.dto.IContractDto;
import com.example.case_study.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {


    Contract findById(int id);

    Page<IContractDto> findAllContract(Pageable pageable);
}
