package com.ua.orders.models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString(exclude = "item")
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private double price;
    private int quantity;
    private String nameItem;
    private String valid;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    SomeItem item;

    public MyOrder(int quantity, String nameItem) {
        this.quantity = quantity;
        this.nameItem = nameItem;
    }

}
