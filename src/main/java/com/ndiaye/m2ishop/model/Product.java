package com.ndiaye.m2ishop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String code;
    private String description;
    private BigDecimal unitPriceWithoutTax;
    private BigDecimal vat;
    private BigDecimal unitPriceWithTax;

    public Product(String code, String description, BigDecimal unitPriceWithoutTax, BigDecimal vat, BigDecimal unitPriceWithTax) {
        this.code = code;
        this.description = description;
        this.unitPriceWithoutTax = unitPriceWithoutTax;
        this.vat = vat;
        this.unitPriceWithTax = unitPriceWithTax;
    }
}
