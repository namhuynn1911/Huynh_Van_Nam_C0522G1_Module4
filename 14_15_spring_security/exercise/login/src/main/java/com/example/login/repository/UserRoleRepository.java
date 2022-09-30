package com.example.login.repository;

import com.example.login.model.AppUser;
import com.example.login.model.UserRole;
import javafx.scene.effect.Light;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    List<UserRole> findByAppUser(AppUser appUser);
}
