package com.store.car.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "car_post")
@Data
@NoArgsConstructor
public class CarPostEntity {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_brand")
    private String brand;

    @Column(name = "car_prince")
    private Double prince;

    @Column(name = "car_description")
    private String description;

    @Column(name = "car_engine")
    private String engineVersion;

    @Column(name = "car_city")
    private String city;

    @Column(name = "car_created")
    private String createdDate;

    @Column(name = "car_post_contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPostEntity ownerPost;


}
