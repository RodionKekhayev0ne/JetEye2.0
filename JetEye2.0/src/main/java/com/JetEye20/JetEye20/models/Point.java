package com.JetEye20.JetEye20.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "point")
@Data
@Builder
public class Point {

    @Id
    private String id;

    private User driver;

    private Double longitude;

    private Double latitude;


    private boolean hasDriver;


    private boolean isDone;


}
