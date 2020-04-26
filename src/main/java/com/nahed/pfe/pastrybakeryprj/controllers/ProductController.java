package com.nahed.pfe.pastrybakeryprj.controllers;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nahed.pfe.pastrybakeryprj.entities.Depot;
import com.nahed.pfe.pastrybakeryprj.entities.Product;
import com.nahed.pfe.pastrybakeryprj.repositories.DepotRepository;
import com.nahed.pfe.pastrybakeryprj.repositories.ProductRepository;

import com.nahed.pfe.pastrybakeryprj.services.ProductService;
import javassist.NotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private DepotRepository depotRepository;


    //Its working
    @GetMapping("/products")
    public Iterable<Product> getAllProduct() {
        return productRepository.findAll();
    }
    //its working it wouldn't work using getOne method
    @GetMapping("/product/{uuid}")
    public Product findProductId(@PathVariable UUID uuid){
        return productRepository.findById(uuid).get();
    }
    //Its working
    @GetMapping("/products/{name}")
    public Product findProductName(@PathVariable(value="name") String name){
        return productRepository.findByName(name);
    }

    //Its working
    @PostMapping("/depots/{depotId}/products")
    public Product createProduct(@RequestBody Product product, @PathVariable(value = "depotId") Long id) throws NotFoundException {
        return depotRepository.findById(id).map(depot -> {
            product.setDepot(depot);
            return productRepository.save(product);
        }).orElseThrow(() -> new NotFoundException("Depot Not Found"));
    }

    //Its working
    @PutMapping("depots/{depotId}/products/{productId}")
    public Product updateProduct(@PathVariable(value = "depotId") Long id,
                                 @PathVariable(value = "productId") UUID uuid,
                                 @RequestBody Product product) throws NotFoundException {
        Product prodExist = depotRepository.findById(id).map(depot -> {
            product.setDepot(depot);
            return productRepository.save(product);
        }).orElseThrow(() -> new NotFoundException("not found"));
        return productRepository.save(prodExist);
    }
//    @DeleteMapping("products/{reference}/{name}")
//    public void eraseProduct(@PathVariable(value="reference") String reference, @PathVariable(value="name") String name){
//
//    }

//    @DeleteMapping("/products/{uuid}")
//    public void eraseProduct(@PathVariable(value="uuid") UUID uuid){

//        productRepository.deleteById(uuid);
//       String reference= prd.getReference();

//       String name= prd.getName();
//        productService.delete(reference,name);
//    }


//    @DeleteMapping("products/{reference}/{name}")
//    public ResponseEntity<?> eraseProduct(@PathVariable(value="reference") String reference, @PathVariable(value="name") String name){
//    productRepository.deleteByReferenceAndName(reference, name);
//    return ResponseEntity.ok().build();
//    }
//    @DeleteMapping("/products/{reference}/{name}")
//    public void eraseProduct(@PathVariable(value="reference") String reference,
//                             @PathVariable(value="name") String name){
//       Product prd = productRepository.findByReferenceAndName(reference, name);
//        productRepository.delete(prd);
//    }
    @DeleteMapping("/depots/{id}/products/{uuid}")
    public ResponseEntity<?> deleteProduct(@PathVariable (value = "id") Long id,
                                           @PathVariable (value = "uuid") UUID uuid) {

        Product prodExist = productRepository.findByUuidAndDepotId(uuid, id);
        productRepository.delete(prodExist);
        return ResponseEntity.ok().build();
    }


    //Its working
    @GetMapping("/products/{reference}/{name}")
    public Product getProductBiRefNam(@PathVariable(name="reference") String reference,
                                   @PathVariable(name="name") String name){
        return productRepository.findByReferenceAndName(reference, name);
    }

//    @DeleteMapping("/depots/{depotId}/products/{productId}")
//    public void eraseProduct(@PathVariable(value="productId") UUID uuid, @PathVariable(value="depotId") Long id ){
//        productService.remove(uuid,id);



// Product prd =productRepository.findByIdAndDepotId(uuid,id).map(product->{
//     productRepository.delete(product);
//     return ResponseEntity.ok().build();
// }).orElseThrow(()->new NotFoundException(" Not Found"));
//    productRepository.deleteById(id);


    }

