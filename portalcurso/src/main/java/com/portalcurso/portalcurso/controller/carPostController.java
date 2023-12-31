package com.portalcurso.portalcurso.controller;

import com.portalcurso.portalcurso.dto.CarPostDTO;
import com.portalcurso.portalcurso.message.KafkaProducerMessage;
import com.portalcurso.portalcurso.service.CarPostStoreService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;


import java.util.List;

@RestController
@RequestMapping("/api/car")
public class carPostController {

    private final Logger LOG = LoggerFactory.getLogger(carPostController.class);

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {

        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
    }

    @PostMapping("/post")
    public ResponseEntity<CarPostDTO> postCarSales(@RequestBody CarPostDTO carPostDTO) {
        LOG.info("MAIN REST API - USANDO EVENTOS/MENSAGENS KAFKA - Producer Car Post information: {}", carPostDTO);
        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<CarPostDTO>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarPostDTO> changeCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id) {
        carPostStoreService.changeCarForSales(carPostDTO, id);
        return new ResponseEntity<CarPostDTO>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarPostDTO> deleteCarSales(@PathVariable("id") String id) {
        carPostStoreService.removeCarSales(id);
        return new ResponseEntity<CarPostDTO>(HttpStatus.OK);
    }

}
