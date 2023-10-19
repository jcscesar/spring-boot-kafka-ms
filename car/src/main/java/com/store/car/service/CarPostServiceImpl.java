package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
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
            carPostEntity.setContact(item.getContactNumber());
        }, () -> {
            throw new RuntimeException();
        });

        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setPrince(carPostDTO.getPrince());
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setEngineVersion(carPostDTO.getEngiveVersion());
        carPostEntity.setCreatedDate(carPostDTO.getCreatedDate());
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
    public void changesCarSales(CarPostDTO carPostDTO, Long postId) {
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
    public void removeCarSales(Long postId) {
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
