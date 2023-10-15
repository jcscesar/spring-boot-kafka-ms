package com.store.car.repository;

import com.store.car.entity.OwnerPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository

public interface OwnerPostRepository extends JpaRepository<OwnerPostEntity, UUID> {

    Optional<OwnerPostEntity> findById(UUID ownerId);
}
