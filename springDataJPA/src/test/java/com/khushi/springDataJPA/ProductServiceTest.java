package com.khushi.springDataJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    public void testGetUserById(){
        // Create products using default constructor and setters
        Product product1 = new Product();
        product1.setId(5L);
        product1.setName("shoes");
        product1.setPrice(400.0);

        Product product2 = new Product();
        product2.setId(7L);
        product2.setName("purse");
        product2.setPrice(600.0);

        // Mock the repository call
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        // Call the service method
        List<Product> result = productService.getAllProducts();

        // Validate the results
        assertEquals(2, result.size());
        assertEquals("shoes", result.get(0).getName());
        assertEquals(400.0, result.get(0).getPrice(), 0.01);
        assertEquals("purse", result.get(1).getName());
        assertEquals(600.0, result.get(1).getPrice(), 0.01);

    }
}
