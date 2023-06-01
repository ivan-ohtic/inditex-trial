package com.trial.inditex.model.mapper;

import com.trial.inditex.model.dto.PriceDTO;
import com.trial.inditex.model.entity.PriceEntity;

public class PriceMapper {

    private PriceMapper() {
    }

    /**
     * Map PriceEntity to PriceDTO
     *
     * @param priceEntity PriceEntity
     * @return PriceDTO
     */
    public static PriceDTO priceEntityToPriceDTO(PriceEntity priceEntity) {
        return new PriceDTO(
                priceEntity.getProductId(),
                priceEntity.getBrandId(),
                priceEntity.getPriceList(),
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getPrice());
    }

}
