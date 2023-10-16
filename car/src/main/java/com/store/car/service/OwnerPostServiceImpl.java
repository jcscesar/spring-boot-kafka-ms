package com.store.car.service;

import com.store.car.dto.OwnerPostDTO;
import com.store.car.entity.OwnerPostEntity;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {
        OwnerPostEntity ownerPostEntity = new OwnerPostEntity();
        ownerPostEntity.setName(ownerPostEntity.getName());
        ownerPostEntity.setType(ownerPostEntity.getType());
        ownerPostEntity.setContactNumber(ownerPostEntity.getContactNumber());
        ownerPostRepository.save(ownerPostEntity);
    }
}
