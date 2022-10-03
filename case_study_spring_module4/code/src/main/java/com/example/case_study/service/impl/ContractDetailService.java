package com.example.case_study.service.impl;

import com.example.case_study.model.ContractDetail;
import com.example.case_study.repository.IContractDetailRepository;
import com.example.case_study.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }
}
