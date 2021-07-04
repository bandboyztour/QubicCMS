package com.qubiccms.api.repository.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.qubiccms.QubicCmsPlugin;
import com.qubiccms.api.model.product.Product;
import com.qubiccms.api.repository.Repository;
import com.qubiccms.configuration.Configuration;
import com.qubiccms.network.Method;
import com.qubiccms.network.NetworkClient;
import com.sun.net.httpserver.Headers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class ProductRepositoryImpl implements Repository<Product, String> {
    /**
     * Storage {@link Product}'s in memory
     * TODO: add sql repository
     */
    private List<Product> products = new ArrayList<>();
    private final Gson gson = new Gson();

    private final NetworkClient networkClient;
    private final Configuration configuration;

    public ProductRepositoryImpl(Configuration configuration,
                                 NetworkClient networkClient) {
        this.networkClient = networkClient;
        this.configuration = configuration;
    }

    @Override
    public Optional<Product> getById(String s) {
        Optional<Product> productOpt = products.stream().filter(product -> product.getUuid().equalsIgnoreCase(s))
                .findFirst();
        if (productOpt.isPresent())
            return productOpt;

        this.loadAll();
        return products.stream().filter(product -> product.getUuid().equalsIgnoreCase(s))
                .findFirst();
//        return Optional.empty(); gson.toJsonTree()
    }

    @Override
    public Optional<List<Product>> loadAll() {
        List<Product> products = new ArrayList<>();

        configuration.getValue("base-host").flatMap(baseHost -> networkClient.doRequest(
                baseHost + "/api/v1/products",
                Method.GET,
                null,
                null
        )).ifPresent(responseData -> {
            gson.fromJson(responseData.getBody(), JsonElement.class)
                    .getAsJsonObject()
                    .get("products")
                    .getAsJsonArray()
                    .get(0) // safe because server api always sent 1 category
                    .getAsJsonObject()
                    .get("products")
                    .getAsJsonArray()
                    .forEach(product -> {
                        products.add(
                                gson.fromJson(product, Product.class)
                        );
                    });
        });
        this.products = products;
        return Optional.of(products);
    }
}
