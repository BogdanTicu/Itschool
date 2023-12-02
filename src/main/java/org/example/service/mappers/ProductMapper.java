package org.example.service.mappers;

import org.example.model.dtos.productDTOS.CreateProductDTO;
import org.example.model.dtos.productDTOS.ResponseProductDTO;
import org.example.model.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public CreateProductDTO toDTO(Product product) {
        CreateProductDTO createProductDTO = new CreateProductDTO();
        createProductDTO.setBrand(product.getBrand());
        createProductDTO.setModel(product.getModel());
        createProductDTO.setPrice(product.getPrice());
        createProductDTO.setYear(product.getYear());
        return createProductDTO;
    }
    public ResponseProductDTO toResponseDTO(Product product) {
        ResponseProductDTO responseProductDTO = new ResponseProductDTO();
        responseProductDTO.setId(product.getId());
        responseProductDTO.setBrand(product.getBrand());
        responseProductDTO.setModel(product.getModel());
        responseProductDTO.setPrice(product.getPrice());
        responseProductDTO.setYear(product.getYear());
        return responseProductDTO;
    }

    public Product toEntity(CreateProductDTO productDTO) {
        Product product = new Product();
        product.setBrand(productDTO.getBrand());
        product.setPrice(productDTO.getPrice());
        product.setYear(productDTO.getYear());
        product.setModel(productDTO.getModel());
        return product;
    }
}
