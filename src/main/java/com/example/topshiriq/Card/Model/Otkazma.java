package com.example.topshiriq.Card.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Otkazma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String kartaRaqam2;

    @Column(nullable = false)
    private String parol;

    @Column(nullable = false)
    private String otkazmaRaqam;

    @Column(nullable = false)
    private String otkazmaMiqdori;

}