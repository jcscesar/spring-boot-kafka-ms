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
import org.slf4j.LoggerFactory;

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
    public ResponseEntity postCarSales(@RequestBody CarPostDTO carPostDTO) {
        LOG.info("USANDO EVENTOS/MENSAGENS KAFKA - Producer Car Post information: {}", carPostDTO);
        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSales(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") String id) {
        carPostStoreService.changeCarForSales(carPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarSales(@PathVariable("id") String id) {
        carPostStoreService.removeCarSales(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
