package com.qubiccms.api;

import com.qubiccms.api.model.product.Product;
import com.qubiccms.api.repository.Repository;
import com.qubiccms.api.repository.impl.ProductRepositoryImpl;
import com.qubiccms.configuration.Configuration;
import com.qubiccms.network.NetworkClient;
import com.qubiccms.network.impl.SimpleNetworkClientImpl;

public abstract class QubicCMS {
    private NetworkClient networkClient = new SimpleNetworkClientImpl();
    private final Configuration configuration;
    private Repository<Product, String> productRepository;

    public QubicCMS(Configuration configuration) {
        this.configuration = configuration;
        this.productRepository = new ProductRepositoryImpl(configuration, networkClient);
    }

    public Repository<Product, String> getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(Repository<Product, String> productRepository) {
        this.productRepository = productRepository;
    }

    public NetworkClient getNetworkClient() {
        return networkClient;
    }

    public void setNetworkClient(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
