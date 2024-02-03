package com.devsuperior.examplemockspy;

import com.devsuperior.examplemockspy.dto.ProductDTO;
import com.devsuperior.examplemockspy.entities.Product;
import com.devsuperior.examplemockspy.repositories.ProductRepository;
import com.devsuperior.examplemockspy.services.ProductService;
import com.devsuperior.examplemockspy.services.exceptions.InvalidDataException;
import com.devsuperior.examplemockspy.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductService service;
    @Mock
    private ProductRepository repository;

    private Long existingId, nonExistingId;
    private Product product;
    private ProductDTO productDTO;

    @BeforeEach
    void setUp(){
        existingId = 1L;
        nonExistingId = 100L;
        product = Factory.createproduct();
        productDTO = Factory.creatProductDTO();

        when(repository.save(ArgumentMatchers.any())).thenReturn(product);

        when(repository.getReferenceById(existingId)).thenReturn(product);
        when(repository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);

    }
    @Test
    public void insertShouldReturnProductDTOWhenValidDate() {
        ProductService serviceSpy = spy(service);
        doNothing().when(serviceSpy).validateData(productDTO);

        ProductDTO result = serviceSpy.insert(productDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getName(), "Playstation");
    }

    @Test
    public void insertShouldReturnInvalidDataExceptionWhenProductNameIsBlank() {
        productDTO.setName("");

        ProductService serviceSpy = spy(service);
        doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);

        Assertions.assertThrows(InvalidDataException.class, () -> {
            ProductDTO result = serviceSpy.insert(productDTO);
        });
    }

    @Test
    public void insertShouldReturnInvalidDataExceptionWhenProductPriceIsInvalid() {
        productDTO.setPrice(-10.0);

        ProductService serviceSpy = spy(service);
        doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);

        Assertions.assertThrows(InvalidDataException.class, () -> {
            ProductDTO result = serviceSpy.insert(productDTO);
        });
    }

    @Test
    public void updateShouldReturnProductDTOWhenIdExistsAndValidateData(){
        ProductService serviceSpy = spy(service);
        doNothing().when(serviceSpy).validateData(productDTO);

        ProductDTO result = serviceSpy.update(existingId, productDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), existingId);
    }

    @Test
    public void updateShouldReturnInvalidDataExceptionWhenIdExistsAndProductNameIsBlank() {
        productDTO.setName("");

        ProductService serviceSpy = spy(service);
        doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);

        Assertions.assertThrows(InvalidDataException.class, () -> {
            ProductDTO result = serviceSpy.update(existingId, productDTO);
        });
    }

    @Test
    public void updateShouldReturnInvalidDataExceptionWhenIdExistsAndProductPriceIsNegativeOrZero() {
        productDTO.setPrice(-10.0);

        ProductService serviceSpy = spy(service);
        doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);

        Assertions.assertThrows(InvalidDataException.class, () -> {
            ProductDTO result = serviceSpy.update(existingId, productDTO);
        });
    }

    @Test
    public void updateShouldReturnResourceNotFoundExceptionWhenIdExistsAndValidateData(){
        ProductService serviceSpy = spy(service);
        doNothing().when(serviceSpy).validateData(productDTO);

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            ProductDTO result = serviceSpy.update(nonExistingId, productDTO);
        });
    }

    @Test
    public void updateShouldReturnResourceNotFoundExceptionWhenIdExistsAndProductNameIsBlank(){
        productDTO.setName("");

        ProductService serviceSpy = spy(service);
        doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);

        Assertions.assertThrows(InvalidDataException.class, () -> {
            ProductDTO result = serviceSpy.update(nonExistingId, productDTO);
        });
    }

    @Test
    public void updateShouldReturnResourceNotFoundExceptionWhenIdExistsAndProductPriceOrZero(){
        productDTO.setPrice(-10.0);

        ProductService serviceSpy = spy(service);
        doThrow(InvalidDataException.class).when(serviceSpy).validateData(productDTO);

        Assertions.assertThrows(InvalidDataException.class, () -> {
            ProductDTO result = serviceSpy.update(nonExistingId, productDTO);
        });
    }
}
