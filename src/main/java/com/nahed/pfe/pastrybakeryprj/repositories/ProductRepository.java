package com.nahed.pfe.pastrybakeryprj.repositories;

import com.nahed.pfe.pastrybakeryprj.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

Product findByReferenceAndName(String reference, String name);
Long deleteByReferenceAndName(String reference, String name);
Product findByuuidAndDepotId(UUID uuid, Long id);

//Product findByRefName(String reference, String name);
Product findByUuidAndDepotId(UUID uuid, Long id);
Product findByName(String name);
}
