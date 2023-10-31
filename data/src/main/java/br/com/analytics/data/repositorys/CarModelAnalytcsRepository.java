package br.com.analytics.data.repositorys;

import br.com.analytics.data.entity.CarModelAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarModelAnalytcsRepository extends JpaRepository<CarModelAnalyticsEntity, Long> {
    Optional<CarModelAnalyticsEntity> findyByModel(String model);
}
