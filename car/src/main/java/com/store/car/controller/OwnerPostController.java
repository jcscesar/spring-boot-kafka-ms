package com.store.car.controller;

import com.store.car.dto.CarPostDTO;
import com.store.car.dto.OwnerPostDTO;
import com.store.car.service.CarPostService;
import com.store.car.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;


    @PostMapping()
    public ResponseEntity createOwner(@RequestBody OwnerPostDTO ownerPostDTO) {
        System.out.println(ownerPostDTO);
        ownerPostService.createOwnerPost(ownerPostDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
