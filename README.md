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

output:
```Javascript
Product{uuid='0dbdce92-6f96-42a8-b097-7512f80f3141', title='test1', description='test1', price=5.0}
Product{uuid='66f1b9b1-43e5-42bd-aa3d-7a3a0c560437', title='test2', description='test2', price=2999.99}
Product{uuid='f597ecc4-296c-4add-8911-bcfdd3983d28', title='test3', description='test3', price=30.0}
Product{uuid='5b673714-c972-4655-bc8d-b82e50b7e43b', title='test4', description='test4' price=680.0}
http://localhost:7878
```
