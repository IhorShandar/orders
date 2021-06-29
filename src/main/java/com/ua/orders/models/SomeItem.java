package com.ua.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString(exclude = "order")
public class SomeItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String name;
    private double priceByOne;
    @JsonIgnore
    @OneToOne(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private MyOrder order;

    public SomeItem(String name, double priceByOne) {
        this.name = name;
        this.priceByOne = priceByOne;
    }

    public SomeItem(String name) {
        this.name = name;
    }
}
