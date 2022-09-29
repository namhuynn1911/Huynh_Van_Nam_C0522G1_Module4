package com.phone_manager.service.impl;

import com.phone_manager.model.Phone;
import com.phone_manager.repository.IPhoneRepository;
import com.phone_manager.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneRepository iPhoneRepository;

    @Override
    public List<Phone> findAll() {
        return iPhoneRepository.findAll();
    }

    @Override
    public Phone findById(int id) {
        return iPhoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone phone) {
        return iPhoneRepository.save(phone);
    }

    @Override
    public void remove(int id) {
        iPhoneRepository.delete(findById(id));
    }
}
