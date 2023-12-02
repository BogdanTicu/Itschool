package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.dtos.CustomResponseDTO;
import org.example.model.dtos.productDTOS.CreateProductDTO;
import org.example.model.dtos.productDTOS.ResponseProductDTO;
import org.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/all")
    public ResponseEntity<CustomResponseDTO> getAllProducts() {

        CustomResponseDTO response = new CustomResponseDTO();
        response.setData(productService.findAll());
        response.setMessage("All products");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> getProductById(@PathVariable("id") Long id) {
        ResponseProductDTO product = productService.findById(id);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted");
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> updateProduct(@PathVariable("id") Long id, @Valid @RequestBody CreateProductDTO productDTO , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
       ResponseProductDTO updatedCustomer = productService.updateProduct(id, productDTO);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseProductDTO> addProduct(@Valid @RequestBody CreateProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResponseProductDTO product = productService.save(productDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

}
