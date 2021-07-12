package com.sallatiy.sallatiy.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.bson.types.Binary;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class File {
    @Id
    @Field
    private String id;

    @Field
    private String referenceId;

    @Field
    private String docType;

    @Field
    private Binary file;
}
