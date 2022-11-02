package com.example.javacrudapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Integer promo;

    @OneToMany(mappedBy="author", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<MobilityEntity> mobilities;
}
