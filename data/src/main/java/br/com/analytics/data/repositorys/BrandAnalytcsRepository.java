package br.com.analytics.data.repositorys;

import br.com.analytics.data.entity.BrandAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandAnalytcsRepository extends JpaRepository<BrandAnalyticsEntity, Long> {
    Optional<BrandAnalyticsEntity> findyByBrand(String brand);
}
