package com.example.javacrudapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
public class MobilityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name="author", nullable = false)
    private UserEntity author;

    private String type;
    private String title;
    private String description;
    private String city;
    private String country;
    private String partner;
    private LocalDate startedOn;
    private LocalDate finishedOn;
}
