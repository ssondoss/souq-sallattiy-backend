package com.sallatiy.sallatiy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private  String id;
    private List<Product> products;
    private String name;
    private  String phone;
    private  String country ;
    private  String city ;
    private String addressDetails;
    private  String notes;
    private  String status;
    private boolean viewed;
    private DiscountCode discountCode;
    private LocalDateTime dateTime;
    private  Float total;
}
