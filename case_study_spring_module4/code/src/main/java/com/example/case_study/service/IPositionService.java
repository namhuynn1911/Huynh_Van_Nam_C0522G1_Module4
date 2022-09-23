package com.example.case_study.service;

import com.example.case_study.model.Position;
import com.example.case_study.repository.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IPositionService {

   List<Position> findAll();
}
