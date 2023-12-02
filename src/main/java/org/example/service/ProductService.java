package org.example.service;

import org.example.model.dtos.productDTOS.CreateProductDTO;
import org.example.model.dtos.productDTOS.ResponseProductDTO;
import org.example.model.entity.Product;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.example.service.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Autowired
    public ProductService(OrderRepository orderRepository, ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<CreateProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public void delete(Long id) {
        //TODO: check if product does exist in database
        try
        {
            productRepository.deleteById(id);
        }
        catch (Exception e)
        {
            System.out.println("Product does not exist");
        }
        productRepository.deleteById(id);
    }

    public ResponseProductDTO updateProduct(Long id, CreateProductDTO productDTO) {
       Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setBrand(productDTO.getBrand());
        product.setModel(productDTO.getModel());
        product.setPrice(productDTO.getPrice());
        product.setYear(productDTO.getYear());
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponseDTO(savedProduct);
    }

   public ResponseProductDTO save(CreateProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponseDTO(savedProduct);

    }

    public ResponseProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toResponseDTO(product);
    }
}
