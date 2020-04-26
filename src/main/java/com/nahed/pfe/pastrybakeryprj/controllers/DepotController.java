package com.nahed.pfe.pastrybakeryprj.controllers;

import com.nahed.pfe.pastrybakeryprj.entities.Depot;

import com.nahed.pfe.pastrybakeryprj.entities.Product;
import com.nahed.pfe.pastrybakeryprj.repositories.DepotRepository;
import com.nahed.pfe.pastrybakeryprj.repositories.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class DepotController {
    @Autowired
    private DepotRepository depotRepository;


    //working
    @GetMapping("/depots")
    public Iterable<Depot> getAll(){
        return  depotRepository.findAll();
    }
    //working
    @GetMapping("/depot/{id}")
    public Depot getDepotById(@PathVariable(value="id") Long id){
        Depot dep=depotRepository.findById(id).get();
        return  dep;
    }
    //working
    @PostMapping("/depots")
    public Depot addDepot(@RequestBody Depot depot) {
        return depotRepository.save(depot);
            }
    //working
     @PutMapping("/depots/{id}")
    public Depot editDepot(@RequestBody Depot depot, @PathVariable Long id){
        Depot existdep =depotRepository.getOne(id);
         BeanUtils.copyProperties(depot, existdep,"id");
         return depotRepository.saveAndFlush(existdep);
     }
     @GetMapping("/depot/name/{name}")
    public List<Depot> filterDepotByName(@PathVariable String name){
        return depotRepository.findByName(name);
     }



    }

