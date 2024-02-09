package ru.gur.archintercessor.Interection.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreateProductRequest {

    private String article;

    private String name;

    private String description;

    private Categories categories;

    private BigDecimal price;

    private Integer quantity;

    private Boolean isAvailable;
}
