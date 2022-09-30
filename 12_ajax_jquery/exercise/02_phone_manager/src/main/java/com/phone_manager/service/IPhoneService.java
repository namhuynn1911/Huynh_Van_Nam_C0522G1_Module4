package com.phone_manager.service;

import com.phone_manager.model.Phone;

import java.util.List;
import java.util.Optional;

public interface IPhoneService {

    List<Phone> findAll();

    Optional<Phone> findById(int id);

    Phone save(Phone phone);

    void remove(int id);
}
