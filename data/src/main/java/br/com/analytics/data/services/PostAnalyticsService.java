package br.com.analytics.data.services;


import br.com.analytics.data.dto.CarPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticsService {

    void saveDataAnalytics(CarPostDTO carPostDTO);
}
