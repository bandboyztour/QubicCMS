# QubicCMS

exmpl
```Java
Configuration configuration = new MapConfigurationImpl(
  Collections.singletonMap("base-host", "http://localhost:7878")
);

QubicCMS qubicCMS = new BaseQubicCMS(configuration);

qubicCMS.getProductRepository()
  .loadAll()
  .ifPresent(products -> {
    products.forEach(System.out::println);
});
```
