package br.com.analytics.data.message;

import br.com.analytics.data.dto.CarPostDTO;
import br.com.analytics.data.services.PostAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaCosumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaCosumerMessage.class);

    @Autowired
    private PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = "analytics-post-topic", groupId = "analytics-posts-group")
    public void listening(CarPostDTO carPostDTO) {
        LOG.info("ANALYTICS DATA - Received Car Post information: {}", carPostDTO);
        postAnalyticsService.saveDataAnalytics(carPostDTO);
    }
}
