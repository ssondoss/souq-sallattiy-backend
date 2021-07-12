package com.sallatiy.sallatiy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String titleArabic;
    private String titleEnglish;
    private String descArabic;
    private String descEnglish;
    private float price;
    private int count;
    private List<String> images;
    private Integer category;
}
