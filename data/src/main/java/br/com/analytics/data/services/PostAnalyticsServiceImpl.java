package br.com.analytics.data.services;

import br.com.analytics.data.dto.CarPostDTO;
import br.com.analytics.data.entity.BrandAnalyticsEntity;
import br.com.analytics.data.entity.CarModelAnalyticsEntity;
import br.com.analytics.data.entity.CarModelPriceEntity;
import br.com.analytics.data.repositorys.BrandAnalytcsRepository;
import br.com.analytics.data.repositorys.CarModelAnalytcsRepository;
import br.com.analytics.data.repositorys.CarPriceAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService {

    @Autowired
    private BrandAnalytcsRepository brandAnalytcsRepository;

    @Autowired
    private CarModelAnalytcsRepository carModelAnalytcsRepository;

    @Autowired
    private CarPriceAnalyticsRepository carPriceAnalyticsRepository;

    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {
        saveBrandAnalytics(carPostDTO.getBrand());
        saveCardModelAnalytics(carPostDTO.getModel());
        saveCardModelPriceAnalytics(carPostDTO.getModel(), carPostDTO.getPrince());
    }

    private void saveBrandAnalytics(String brand) {
        BrandAnalyticsEntity brandAnalyticsEntity = new BrandAnalyticsEntity();
        brandAnalytcsRepository.findyByBrand(brand).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            brandAnalytcsRepository.save(item);
        }, () -> {
            brandAnalyticsEntity.setBrand(brand);
            brandAnalyticsEntity.setPosts(1L);
            brandAnalytcsRepository.save(brandAnalyticsEntity);
        });

    }

    private void saveCardModelAnalytics(String model) {
        CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();
        carModelAnalytcsRepository.findyByModel(model).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            carModelAnalytcsRepository.save(item);
        }, () -> {
            carModelAnalyticsEntity.setModel(model);
            carModelAnalyticsEntity.setPosts(1L);
            carModelAnalytcsRepository.save(carModelAnalyticsEntity);
        });
    }

    private void saveCardModelPriceAnalytics(String model, Double price) {
        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(model);
        carModelPriceEntity.setPrice(price);
        carPriceAnalyticsRepository.save(carModelPriceEntity);
    }

}
