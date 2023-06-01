package com.trial.inditex.repository;

import com.trial.inditex.model.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<PriceEntity, String> {

    /**
     * Get all prices data of a brand/product at certain datetime (date will be between start and end date)
     *
     * @param brandId   Brand identifier
     * @param productId Product identifier
     * @param date      Date
     * @return List<PriceEntity> list of possible prices for the product at certain datetime
     */
    @Query(value = "select * from PRICES p where p.brand_id = :brandId and p.product_id = :productId and p.start_date <= :date and p.end_date >= :date", nativeQuery = true)
    List<PriceEntity> getPrices(Integer brandId, Integer productId, LocalDateTime date);

}
