package com.nahed.pfe.pastrybakeryprj.services;

import com.nahed.pfe.pastrybakeryprj.entities.Product;
import com.nahed.pfe.pastrybakeryprj.repositories.DepotRepository;
import com.nahed.pfe.pastrybakeryprj.repositories.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.ReportAsSingleViolation;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DepotRepository depotRepository;

//    public Product findProductByNameAndRefe(String reference, String name){
//        return productRepository.findByReferenceAndName(reference, name);
//
//    }

public void deleteByRefName(String ref, String name) {
    productRepository.deleteByReferenceAndName(ref, name);
    }
//public void delete(UUID id) {
//        productRepository.deleteById(id);
//    }

    public void remove(UUID uuid,Long id) {
        Product prodExist = productRepository.findByUuidAndDepotId(uuid,id);
        productRepository.delete(prodExist);
    }
//        }).orElseThrow(() -> new NotFoundException("not found"));
//        productRepository.save(prodExist);

}
