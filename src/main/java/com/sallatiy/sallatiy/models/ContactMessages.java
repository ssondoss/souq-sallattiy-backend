package com.sallatiy.sallatiy.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessages {
    @Id
    private String id;
    private  String name ;
    private String email;
    private String message;
    private LocalDateTime dateTime;
    private  Boolean seen;
}
