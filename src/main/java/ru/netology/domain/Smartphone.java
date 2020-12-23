package ru.netology.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Smartphone extends Product {
    public String manufacturer;

    public Smartphone(int id, String productName, int productPrice, String manufacturer) {
        super(id, productName, productPrice);
        this.manufacturer = manufacturer;
    }
}
