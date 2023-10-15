package com.store.car.message;

import com.store.car.dto.CarPostDTO;
import com.store.car.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaCosumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaCosumerMessage.class);

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostDTO carPostDTO) {
        LOG.info("Received Car Post information: {}", carPostDTO);
        carPostService.mewPostDetails(carPostDTO);
    }
}