package com.nahed.pfe.pastrybakeryprj.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nahed.pfe.pastrybakeryprj.entities.enumerations.ProductUnitEnum;
import com.nahed.pfe.pastrybakeryprj.entities.enumerations.TypeProductEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="product")
@ToString
public class Product {

//    @Id
//    @GeneratedValue(generator = "system-uuid"
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
//    private String id;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy ="org.hibernate.id.UUIDGenerator")
   // @Column(columnDefinition = "uuid", updatable = false)
    private UUID uuid;


    private String reference;
    @Column(name="reference_provider")
    private String referenceProvider;
    private String name;
    private BigDecimal  quantity;
    @Column(name=" purchase_unit_price")
    private BigDecimal purchaseUnitPrice;
    @Column(name="percentage_margin")
    private Integer percentageMargin;
    @Column(name="sale_unit_price")
    private BigDecimal saleUnitPrice;
    @Column(name="stock_limit")
    private BigDecimal stockLimit;
    @Column(name=" stock_limit_alert")
    private boolean stockLimitAlert;
    private TypeProductEnum type;
    @Column(name="unit_type")
    private ProductUnitEnum unitType;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] image;
    @Column(name=" is_displayed_in_cachier")
    private boolean isDisplayedInCachier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="depot_id")
    private Depot depot;

//    @JsonCreator
//    public static Product fromString(String id) {
//        return new Product(UUID.fromString(id));
//    }



}
