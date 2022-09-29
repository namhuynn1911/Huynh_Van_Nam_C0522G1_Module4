package com.phone_manager.repository;

import com.phone_manager.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone,Integer> {
    Phone findById(int id);
}
