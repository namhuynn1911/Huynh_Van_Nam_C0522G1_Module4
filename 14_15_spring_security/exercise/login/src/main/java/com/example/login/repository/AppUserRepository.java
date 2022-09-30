package com.example.login.repository;


import com.example.login.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer> {

    AppUser findByUserName(String name);


}
