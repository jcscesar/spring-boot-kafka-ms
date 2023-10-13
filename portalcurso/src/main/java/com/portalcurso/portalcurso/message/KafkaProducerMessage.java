package com.portalcurso.portalcurso.message;

import com.portalcurso.portalcurso.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    public KafkaTemplate<String, CarPostDTO> KafkaTemplate;

    private final String KAFKA_TOPIC = "car-post-topic";

    public void sendMessage(CarPostDTO carPostDTO) {
        KafkaTemplate.send(KAFKA_TOPIC, carPostDTO);
    }
}
