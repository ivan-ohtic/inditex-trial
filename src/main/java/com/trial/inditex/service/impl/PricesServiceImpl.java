package com.trial.inditex.service.impl;

import com.trial.inditex.model.dto.PriceDTO;
import com.trial.inditex.model.entity.PriceEntity;
import com.trial.inditex.model.mapper.PriceMapper;
import com.trial.inditex.repository.PricesRepository;
import com.trial.inditex.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;

    @Autowired
    public PricesServiceImpl(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PriceDTO getPrice(Integer brandId, Integer productId, LocalDateTime date) {
        List<PriceEntity> prices = pricesRepository.getPrices(brandId, productId, date);
        PriceEntity finalPrice = null;

        if (prices != null && !prices.isEmpty()) {
            // Get the highest priority price
            finalPrice = prices.stream()
                    .max(Comparator.comparing(PriceEntity::getPriority))
                    .get();
        }

        return finalPrice != null ? PriceMapper.priceEntityToPriceDTO(finalPrice) : null;
    }

}
