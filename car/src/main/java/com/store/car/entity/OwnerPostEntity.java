package com.store.car.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "car_post")
@Data
@NoArgsConstructor
public class OwnerPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Column(name = "owner_type")
    private String type;

    @Column(name = "owner_contact")
    private String contactNumber;


}
