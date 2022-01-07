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
    private String name;
    private String description;
    private BigDecimal unitPriceWithoutTax;
    private BigDecimal vat;
    private BigDecimal unitPriceWithTax;

    public Product(String code, String name, String description, BigDecimal unitPriceWithoutTax, BigDecimal vat) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.unitPriceWithoutTax = unitPriceWithoutTax;
        this.vat = vat;
    }

    public Product(String code, String name, String description, BigDecimal unitPriceWithoutTax, BigDecimal vat, BigDecimal unitPriceWithTax) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.unitPriceWithoutTax = unitPriceWithoutTax;
        this.vat = vat;
        this.unitPriceWithTax = unitPriceWithTax;
    }
}
