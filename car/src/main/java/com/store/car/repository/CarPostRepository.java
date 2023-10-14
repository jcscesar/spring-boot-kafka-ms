package com.store.car.repository;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarPostRepository extends JpaRepository<CarPostEntity, UUID> {}
