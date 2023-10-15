package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class CarPostServiceImpl implements CarPostService {


    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void mewPostDetails(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = mapCarDTotoEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
    }

    private CarPostEntity mapCarDTotoEntity(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = new CarPostEntity();
        ownerPostRepository.findById(carPostDTO.getOwnerId()).ifPresentOrElse(item -> {
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContact(item.getContact());
        }, () -> {
            throw new RuntimeException();
        });

        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostEntity.getBrand());
        carPostEntity.setPrince(carPostEntity.getPrince());
        carPostEntity.setCity(carPostEntity.getCity());
        carPostEntity.setDescription(carPostEntity.getDescription());
        carPostEntity.setEngineVersion(carPostEntity.getEngineVersion());
        carPostEntity.setCreatedDate(carPostEntity.getCreatedDate());
        return carPostEntity;

    }

    @Override
    public List<CarPostDTO> getCatSales() {
        List<CarPostDTO> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(carPostEntity -> {
            listCarsSales.add(mapCarEntityToDto(carPostEntity));
        });
        return listCarsSales;
    }


    @Override
    public void changesCarSales(CarPostDTO carPostDTO, UUID postId) {
        carPostRepository.findById(postId).ifPresentOrElse(carPostItems -> {
            carPostItems.setDescription(carPostDTO.getDescription());
            carPostItems.setContact(carPostDTO.getContact());
            carPostItems.setPrince(carPostDTO.getPrince());
            carPostItems.setBrand(carPostDTO.getBrand());
            carPostItems.setEngineVersion(carPostDTO.getEngiveVersion());
            carPostItems.setModel(carPostDTO.getModel());
            carPostRepository.save(carPostItems);
        }, () -> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void removeCarSales(UUID postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPostDTO mapCarEntityToDto(CarPostEntity carPostEntity) {
        return CarPostDTO.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engiveVersion(carPostEntity.getEngineVersion())
                .createdDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerPost().getName())
                .prince(carPostEntity.getPrince())
                .build();
    }
}
