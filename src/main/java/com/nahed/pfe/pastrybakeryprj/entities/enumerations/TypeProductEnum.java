package com.nahed.pfe.pastrybakeryprj.entities.enumerations;

public enum TypeProductEnum {
    PRODUIT("Produit"),
    MATIEREPREMIER("Matiere Premiere");

    private final String name;
    TypeProductEnum(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}
