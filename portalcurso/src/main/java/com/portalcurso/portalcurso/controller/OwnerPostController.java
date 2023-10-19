package com.portalcurso.portalcurso.controller;

import com.portalcurso.portalcurso.dto.OwnerPostDTO;
import com.portalcurso.portalcurso.service.OwnerPostServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerPostController {

    private final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);

    @Autowired
    private OwnerPostServer ownerPostServer;

    @PostMapping
    public ResponseEntity<OwnerPostDTO> createOwnerCar(@RequestBody OwnerPostDTO ownerPostDTO) {
        LOG.info("USANDO API REST - Criando Novo Usuário: {}", ownerPostDTO);
        System.out.println("ownerPostDTO "+ ownerPostDTO);
        ownerPostServer.createOwnerCar(ownerPostDTO);
        return new ResponseEntity<OwnerPostDTO>(HttpStatus.OK);
    }

}
