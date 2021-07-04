package com.qubiccms.api.model.product;

import java.math.BigDecimal;

public class Product {
    private final String uuid;
    private final String title;
    private final String description;
    private final BigDecimal price;

    public Product(
            String uuid,
            String title,
            String description,
            BigDecimal price) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uuid='" + uuid + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
