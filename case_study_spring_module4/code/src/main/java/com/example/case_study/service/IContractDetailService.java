package com.example.case_study.service;

import com.example.case_study.model.ContractDetail;
import com.example.case_study.model.CustomerType;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> findAll();
}
