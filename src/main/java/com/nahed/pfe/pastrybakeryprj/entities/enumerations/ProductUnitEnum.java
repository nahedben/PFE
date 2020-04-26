package com.nahed.pfe.pastrybakeryprj.entities.enumerations;

public enum ProductUnitEnum {
    NONE("None"),
    METER("Meter"),
    KG("Kg"),
    LITER("Liter"),
    PIECE("Piece"),
    UNIT("Unit");

    private final String name;
    ProductUnitEnum(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }


}
