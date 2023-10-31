package br.com.analytics.data.repositorys;

import br.com.analytics.data.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarPriceAnalyticsRepository extends JpaRepository<CarModelPriceEntity, Long> {

}