package com.nahed.pfe.pastrybakeryprj.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="depot")
@ToString
public class Depot {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private String details;
    private String location;

    @OneToMany(cascade={CascadeType.ALL},mappedBy="depot")
    @JsonIgnore
    private Set<Product> products=new HashSet<>();


}
