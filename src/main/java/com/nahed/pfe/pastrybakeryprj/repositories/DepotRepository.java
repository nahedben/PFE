package com.nahed.pfe.pastrybakeryprj.repositories;

import com.nahed.pfe.pastrybakeryprj.entities.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DepotRepository  extends JpaRepository <Depot,Long>{
    List<Depot> findByName(String name);
}
