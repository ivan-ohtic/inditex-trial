package com.trial.inditex.controller;

import com.trial.inditex.model.dto.PriceDTO;
import com.trial.inditex.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/prices")
public class PricesController {

    private final PricesService pricesService;

    @Autowired
    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    /**
     * Get price data for a product at a given datetime, in case more than one is retrieved, the one with most priority is returned
     *
     * @param brandId   Brand identifier
     * @param productId Product identifier
     * @param date      Date
     * @return PriceDTO price data with maximum priority
     */
    @GetMapping("/{brand_id}/{product_id}/{date}")
    public PriceDTO getPrice(@PathVariable(value = "brand_id") final Integer brandId,
                             @PathVariable(value = "product_id") final Integer productId,
                             @PathVariable(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime date) {
        return pricesService.getPrice(brandId, productId, date);
    }

}
