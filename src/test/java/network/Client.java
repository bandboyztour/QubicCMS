package network;

import com.qubiccms.api.BaseQubicCMS;
import com.qubiccms.api.QubicCMS;
import com.qubiccms.configuration.Configuration;
import com.qubiccms.configuration.MapConfigurationImpl;

import java.util.Collections;

public class Client {
    public static void main(String[] args) {
        Configuration configuration = new MapConfigurationImpl(
                Collections.singletonMap("base-host", "http://localhost:7878")
        );

        QubicCMS qubicCMS = new BaseQubicCMS(configuration);

        qubicCMS.getProductRepository()
                .loadAll()
                .ifPresent(products -> {
                    products.forEach(System.out::println);
                });
    }
}
