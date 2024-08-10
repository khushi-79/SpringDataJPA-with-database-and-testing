package com.khushi.springDataJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    public void testGetAllProducts(){
        Product product1 = new Product();
        product1.setName("shoes");
        product1.setPrice(400.0);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("purse");
        product2.setPrice(600.0);
        productRepository.save(product2);

        List<Product> result = productService.getAllProducts();

        assertEquals(2,result.size());
        assertEquals("shoes",result.get(0).getName());
        assertEquals(400.0,result.get(0).getPrice(),0.01);

    }
}
