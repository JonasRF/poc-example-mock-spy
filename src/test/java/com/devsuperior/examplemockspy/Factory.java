package com.devsuperior.examplemockspy;

import com.devsuperior.examplemockspy.dto.ProductDTO;
import com.devsuperior.examplemockspy.entities.Product;

public class Factory {

    public static Product createproduct() {
        return new Product(1L, "Playstation", 2000.0);
    }

    public static ProductDTO creatProductDTO() {
        Product product = createproduct();
        return new ProductDTO(product);
    }
}
