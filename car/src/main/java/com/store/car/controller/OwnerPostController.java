package com.store.car.controller;

import com.store.car.dto.OwnerPostDTO;
import com.store.car.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;


    @PostMapping()
    public ResponseEntity<OwnerPostDTO> createOwner(@RequestBody OwnerPostDTO ownerPostDTO) {
        System.out.println(ownerPostDTO);
        ownerPostService.createOwnerPost(ownerPostDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
