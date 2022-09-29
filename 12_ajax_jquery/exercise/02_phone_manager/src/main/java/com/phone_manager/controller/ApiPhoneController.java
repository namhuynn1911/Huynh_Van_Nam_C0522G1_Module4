package com.phone_manager.controller;

import com.phone_manager.model.Phone;
import com.phone_manager.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
@CrossOrigin("*")
public class ApiPhoneController {

    @Autowired
    private IPhoneService iPhoneService;

    @PostMapping("/save")
    public ResponseEntity<Phone> createSmartphone(@RequestBody Phone phone) {
        return new ResponseEntity<>(iPhoneService.save(phone), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Phone>> showPhone() {
        List<Phone> blogsList = iPhoneService.findAll();
        if (blogsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsList, HttpStatus.OK);
    }
}
