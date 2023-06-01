package com.trial.inditex.service;

import com.trial.inditex.model.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PricesService {

    /**
     * Get price data for a product at a given datetime, in case more than one is retrieved, the one with most priority is returned
     *
     * @param brandId   Brand identifier
     * @param productId Product identifier
     * @param date      Date
     * @return PriceDTO price data with maximum priority
     */
    PriceDTO getPrice(Integer brandId, Integer productId, LocalDateTime date);

}
