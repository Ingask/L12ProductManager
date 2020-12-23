package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class Book extends Product{
    private String author;


    public Book(int id, String productName, int productPrice, String author) {
        super(id, productName, productPrice);
        this.author = author;
    }
}

