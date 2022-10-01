package com.example.case_study.service;

import com.example.case_study.model.Facility;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {

    Page<Facility> findByNameAll(String name,Pageable pageable);

    void save(Facility facility);

    Facility findById(int id);

    Facility update(Facility facility);

    void remove(int id);


}
