package com.trial.inditex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class PricesTests {

    @Autowired
    private MockMvc mockMvc;

    private String URL_PATH = "/api/v1/prices";
    private int PRODUCT_ID = 35455;
    private int BRAND_ID = 1;

    /**
     * Check output price data for brand 1, product 35455, datetime 2020-06-14 10:00:00.000
     *
     * @throws Exception
     */
    @Test
    void getPrice2020061410Test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_PATH + "/" + BRAND_ID + "/" + PRODUCT_ID + "/2020-06-14T10:00:00.000Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(PRODUCT_ID)))
                .andExpect(jsonPath("$.brandId", is(BRAND_ID)))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.price", is(35.5)));
    }

    /**
     * Check output price data for brand 1, product 35455, datetime 2020-06-14 16:00:00.000
     *
     * @throws Exception
     */
    @Test
    void getPrice2020061416Test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_PATH + "/" + BRAND_ID + "/" + PRODUCT_ID + "/2020-06-14T16:00:00.000Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(PRODUCT_ID)))
                .andExpect(jsonPath("$.brandId", is(BRAND_ID)))
                .andExpect(jsonPath("$.priceList", is(2)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14T15:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-06-14T18:30:00")))
                .andExpect(jsonPath("$.price", is(25.45)));
    }

    /**
     * Check output price data for brand 1, product 35455, datetime 2020-06-14 21:00:00.000
     *
     * @throws Exception
     */
    @Test
    void getPrice2020061421Test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_PATH + "/" + BRAND_ID + "/" + PRODUCT_ID + "/2020-06-14T21:00:00.000Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(PRODUCT_ID)))
                .andExpect(jsonPath("$.brandId", is(BRAND_ID)))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.price", is(35.5)));
    }

    /**
     * Check output price data for brand 1, product 35455, datetime 2020-06-15 10:00:00.000
     *
     * @throws Exception
     */
    @Test
    void getPrice2020061510Test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_PATH + "/" + BRAND_ID + "/" + PRODUCT_ID + "/2020-06-15T10:00:00.000Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(PRODUCT_ID)))
                .andExpect(jsonPath("$.brandId", is(BRAND_ID)))
                .andExpect(jsonPath("$.priceList", is(3)))
                .andExpect(jsonPath("$.startDate", is("2020-06-15T00:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-06-15T11:00:00")))
                .andExpect(jsonPath("$.price", is(30.5)));
    }

    /**
     * Check output price data for brand 1, product 35455, datetime 2020-06-16 21:00:00.000
     *
     * @throws Exception
     */
    @Test
    void getPrice2020061621Test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_PATH + "/" + BRAND_ID + "/" + PRODUCT_ID + "/2020-06-16T21:00:00.000Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(PRODUCT_ID)))
                .andExpect(jsonPath("$.brandId", is(BRAND_ID)))
                .andExpect(jsonPath("$.priceList", is(4)))
                .andExpect(jsonPath("$.startDate", is("2020-06-15T16:00:00")))
                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.price", is(38.95)));
    }

}
